package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    app.goTo().gotoHomePage();

    ContactData contact = new ContactData().withFirstname("Yevgeniy").withLastname("Nozikov").withNickname("NEE").withMobile("+77075555555").withEmail("nee@nee.kz").withGroup("Group1");

    Set<ContactData> before = app.contact().all();

    app.contact().create(contact, true);

    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }

}
