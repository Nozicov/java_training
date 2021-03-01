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
    app.goTo().gotoHomePage();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData().withFirstname("Yevgeniy").withLastname("Nozikov").withNickname("NEE").withMobile("+77075555555").withEmail("nee@nee.kz").withGroup("Group1"), true);
    }
  }

  @Test
  public void testContactModification () throws Exception {
    List<ContactData> before = app.contact().list();

    int index = before.size() - 1;
    int id = before.get(index).getId();
    ContactData contact = new ContactData().withId(id).withFirstname("Yevgeniy-up").withLastname("Nozikov-up").withNickname("NEE-up").withMobile("+77075555888").withEmail("nee@nee.kz-up").withGroup("Group-up");

    app.contact().modify(index, contact);

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
