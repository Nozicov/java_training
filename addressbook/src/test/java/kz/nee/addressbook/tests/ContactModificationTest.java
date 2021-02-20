package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification () throws Exception {
    app.getContactHelper().selectContactEdit();
    app.getContactHelper().fillContactForm(new ContactData("Yevgeniy2", "Nozikov2", "NEE2", "+772725557772", "+770755555552", "nee@nee.kz2"));
    app.getContactHelper().submitUpdateContact();
    app.getSessionHelper().logout();
  }

}
