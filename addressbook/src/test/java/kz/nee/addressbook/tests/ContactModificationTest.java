package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePrecondirions(){
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", null, "+77075555555", "nee@nee.kz", "Group1"), true);
    }
  }

  @Test
  public void testContactModification () throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();

    int index = before.size() - 1;
    int id = (int) before.get(index).getId();
    ContactData contact = new ContactData(id, "Yevgeniy2", "Nozikov2", null, null, "+770755555552", "nee@nee.kz2", null);

    app.getContactHelper().modifyContact(index, contact);

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
