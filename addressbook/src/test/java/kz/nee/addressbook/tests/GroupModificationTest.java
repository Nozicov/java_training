package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModificationTest() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Group-up", "Logo-up", "Comment-up"));
    }
    app.getSessionHelper().logout();
  }
}
