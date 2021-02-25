package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", "+77272555777", "+77075555555", "nee@nee.kz", "Group1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectedUpdateContact();
    app.getContactHelper().fillContactForm(new ContactData("Yevgeniy2", "Nozikov2", "NEE2", "+772725557772", "+770755555552", "nee@nee.kz2", null), false);
    app.getContactHelper().submitUpdateContact();
    if (! app.getContactHelper().isVisibleSuccessMessage()){
      Assert.fail("Successful contact modification message was not displayed!");
    }
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(before, after);
    app.getSessionHelper().logout();
  }

}
