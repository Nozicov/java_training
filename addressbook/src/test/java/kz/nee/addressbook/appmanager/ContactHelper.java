package kz.nee.addressbook.appmanager;

import kz.nee.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
  }

  public void selectContactEdit() {
    click(By.xpath("//img[@title='Edit'][1]"));
  }

  public void submitDeleteContact() {
    click(By.xpath("//input[@value=\"Delete\"]"));
  }

  public void submitUpdateContact() {
    click(By.xpath("//input[@value=\"Update\"][1]"));
  }

}
