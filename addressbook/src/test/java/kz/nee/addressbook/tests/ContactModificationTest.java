package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import kz.nee.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePrecondirions(){
    app.goTo().gotoHomePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Yevgeniy").withLastname("Nozikov").withNickname("NEE").withMobile("+77075555555").withEmail("nee@nee.kz").withGroup("Group1"), true);
    }
  }

  @Test
  public void testContactModification () throws Exception {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("Yevgeniy-up")
            .withLastname("Nozikov-up")
            .withNickname("NEE-up")
            .withMobile("+77075555888")
            .withEmail("nee@nee.kz-up")
            .withGroup("Group-up");
    app.contact().modify(contact);
    Contacts after = app.contact().all();

    assertEquals(before.size(), after.size());
    assertThat(after, equalTo(before.withModified(contact, modifiedContact)));
  }

}
