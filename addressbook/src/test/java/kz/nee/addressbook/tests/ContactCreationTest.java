package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", "+77272555777", "+77075555555", "nee@nee.kz", "Group3"), true);
    app.getSessionHelper().logout();
  }

}
