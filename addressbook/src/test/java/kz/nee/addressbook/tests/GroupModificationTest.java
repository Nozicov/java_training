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
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Group", "Logo", "Comment"));
    }
  }

  @Test
  public void testGroupModificationTest() throws Exception {

    List<GroupData> before = app.getGroupHelper().getGroupList();

    int index = before.size() - 1;
    int id = before.get(index).getId();
    GroupData group = new GroupData(id, "Group-up", "Logo-up", "Comment-up");

    app.getGroupHelper().modifyGroup(index, group);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
