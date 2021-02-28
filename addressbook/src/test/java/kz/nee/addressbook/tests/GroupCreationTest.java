package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.ContactData;
import kz.nee.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("Group1", "Logo1", "Comment1");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    //int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    int max = after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId();
    group.setId(max);
    before.add(group);

    //Comparator<? super GroupData> byId = (c1, c2) -> Integer.compare(g1.getId(), g2.getId());
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);

    app.getSessionHelper().logout();
  }

}
