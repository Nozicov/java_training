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
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Yevgeniy", "Nozikov", "NEE", null, "+77075555555", "nee@nee.kz", "Group1");
    app.getContactHelper().createContact(contact, true);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    //int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    int max = after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId();
    contact.setId(max);
    before.add(contact);

    //Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
