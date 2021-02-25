package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", "+77272555777", "+77075555555", "nee@nee.kz", "Group1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectedUpdateContact(before.size() - 1);
    app.getContactHelper().fillContactForm(new ContactData("Yevgeniy2", "Nozikov2", "NEE2", "+772725557772", "+770755555552", "nee@nee.kz2", null), false);
    app.getContactHelper().submitUpdateContact();
    if (! app.getContactHelper().isVisibleSuccessMessage()){
      Assert.fail("Successful contact modification message was not displayed!");
    }
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());
    app.getSessionHelper().logout();
  }

}
