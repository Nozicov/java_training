package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", null, "+77075555555", "nee@nee.kz", "Group1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectedUpdateContact(before.size() - 1);
    int id = (int) before.get(before.size() - 1).getId();
    ContactData contact = new ContactData(id, "Yevgeniy2", "Nozikov2", null, null, "+770755555552", "nee@nee.kz2", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitUpdateContact();
    if (! app.getContactHelper().isVisibleSuccessMessage()){
      Assert.fail("Successful contact modification message was not displayed!");
    }
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(before.size() - 1);
    before.add(contact);

    //Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);

    app.getSessionHelper().logout();
  }

}
