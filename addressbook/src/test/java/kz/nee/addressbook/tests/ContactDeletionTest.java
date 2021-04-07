package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import kz.nee.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().count() == 0){
      app.contact().create(new ContactData().withFirstname("Yevgeniy").withLastname("Nozikov").withNickname("NEE").withMobile("+77075555555").withEmail("nee@nee.kz").withGroup("Group1"), true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception  {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertEquals(app.contact().count(), before.size() - 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }

}
