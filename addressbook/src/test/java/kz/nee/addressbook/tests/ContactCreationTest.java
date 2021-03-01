package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    ContactData contact = new ContactData("Yevgeniy", "Nozikov", "NEE", null, "+77075555555", "nee@nee.kz", "Group1");

    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().createContact(contact, true);
    app.getContactHelper().gotoContactPage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId();
    contact.setId(max);
    before.add(contact);

    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
