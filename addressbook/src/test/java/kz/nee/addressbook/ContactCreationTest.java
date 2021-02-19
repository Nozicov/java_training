package kz.nee.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoCreationContactPage();
    fillContactForm(new ContactData("Yevgeniy", "Nozikov", "NEE", "+77272555777", "+77075555555", "nee@nee.kz"));
    submitContactCreation();
    gotoHomePage();
    logout();
  }

}
