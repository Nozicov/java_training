package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", "+77272555777", "+77075555555", "nee@nee.kz", "Group3"), true);
    if (! app.getContactHelper().isVisibleSuccessMessage()){
      Assert.fail("Successful contact creation message was not displayed!");
    }
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
    app.getSessionHelper().logout();
  }

}
