package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModificationTest() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Group-up", "Logo-up", "Comment-up"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupPage();
  }
}
