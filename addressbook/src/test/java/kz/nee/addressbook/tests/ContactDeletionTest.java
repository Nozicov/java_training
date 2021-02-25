package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception  {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", "+77272555777", "+77075555555", "nee@nee.kz", "Group1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectedContact();
    app.getContactHelper().submitSelectedDeleteContact();
    if (! app.getContactHelper().isVisibleSuccessMessage()){
      Assert.fail("Successful contact deletion message was not displayed!");
    }
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
    app.getSessionHelper().logout();
  }
}
