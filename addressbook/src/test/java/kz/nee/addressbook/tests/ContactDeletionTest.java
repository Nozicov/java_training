package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception  {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", "+77272555777", "+77075555555", "nee@nee.kz", "Group1"), true);
    }
    app.getContactHelper().selectContactEdit();
    app.getContactHelper().submitDeleteContact();
    app.getSessionHelper().logout();
  }
}
