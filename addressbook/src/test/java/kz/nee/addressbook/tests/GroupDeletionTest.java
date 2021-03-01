package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Group", "Logo", "Comment"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {

    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;

    app.getGroupHelper().deleteGroup(index);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);

    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
