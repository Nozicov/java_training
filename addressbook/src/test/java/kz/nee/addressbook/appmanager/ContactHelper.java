package kz.nee.addressbook.appmanager;

import kz.nee.addressbook.model.ContactData;
import kz.nee.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      try {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } catch (NoSuchElementException ex) {
        new Select(wd.findElement(By.name("new_group"))).selectByIndex(0);
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    if (! isVisibleSuccessMessage()){
      Assert.fail("Successful contact creation message was not displayed!");
    }
    returnContactPage();
  }

  public void modify(ContactData contact) {
    selectedUpdateContactById(contact.getId());
    fillContactForm(contact, false);
    submitUpdateContact();
    if (! isVisibleSuccessMessage()){
      Assert.fail("Successful contact modification message was not displayed!");
    }
    gotoContactPage();
  }

  public void deletion(ContactData contact) {
    selectedContactById(contact.getId());
    submitSelectedDeleteContact();
    if (! isVisibleSuccessMessage()){
      Assert.fail("Successful contact deletion message was not displayed!");
    }
    gotoContactPage();
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectedContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void submitSelectedDeleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    if(! isAlertPresent()){
      Assert.fail("No warning window displayed!");
    }
  }

  public void selectedUpdateContactById(int id) {
    wd.findElement(By.xpath("//a[contains(@href,'edit.php?id=" + id + "')]")).click();
  }

  public void submitUpdateContact() {
    click(By.xpath("//input[@value=\"Update\"][1]"));
  }

  public void returnContactPage() {
    click(By.linkText("home page"));
  }

  public void gotoContactPage() {
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[@title='Edit'][1]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element: elements){
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lastname  = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String email = cells.get(4).findElement(By.tagName("a")).getText();
      String mobile = cells.get(5).getText();
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withMobile(mobile).withEmail(email);
      contacts.add(contact);
    }
    return contacts;
  }

}
