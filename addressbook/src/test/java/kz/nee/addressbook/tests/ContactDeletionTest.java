package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yevgeniy", "Nozikov", "NEE", null, "+77075555555", "nee@nee.kz", "Group1"), true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception  {

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;

    app.getContactHelper().deletionContact(index);

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);

    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }
}
