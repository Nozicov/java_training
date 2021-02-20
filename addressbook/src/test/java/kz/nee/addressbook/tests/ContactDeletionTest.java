package kz.nee.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception  {
    app.getContactHelper().selectContactEdit();
    app.getContactHelper().submitDeleteContact();
    app.getSessionHelper().logout();
  }
}
