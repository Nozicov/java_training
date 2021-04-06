package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import kz.nee.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().gotoHomePage();
    ContactData contact = new ContactData().withFirstname("Yevgeniy").withLastname("Nozikov").withNickname("NEE").withMobile("+77075555555").withEmail("nee@nee.kz").withGroup("Group1");
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdd(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() throws Exception {
    app.goTo().gotoHomePage();
    ContactData contact = new ContactData().withFirstname("Yevgeniy'").withLastname("Nozikov").withNickname("NEE").withMobile("+77075555555").withEmail("nee@nee.kz").withGroup("Group1");
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}
