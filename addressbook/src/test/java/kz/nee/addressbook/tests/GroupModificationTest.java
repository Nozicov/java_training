package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData().withName("Test group").withHeader("Text heater").withFooter("Text footer"));
    }
  }

  @Test
  public void testGroupModificationTest() throws Exception {

    List<GroupData> before = app.group().list();

    int index = before.size() - 1;
    int id = before.get(index).getId();
    GroupData group = new GroupData().withId(id).withName("Test group-up").withHeader("Text heater-up").withFooter("Text footer-up");

    app.group().modify(index, group);

    List<GroupData> after = app.group().list();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
