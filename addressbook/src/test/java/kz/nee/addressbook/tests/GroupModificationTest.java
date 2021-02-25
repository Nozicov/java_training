package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModificationTest() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Group", "Logo", "Comment"));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Group-up", "Logo-up", "Comment-up"));
    app.getGroupHelper().submitGroupModification();
    if (! app.getGroupHelper().isVisibleSuccessMessage()){
      Assert.fail("Successful group deletion message was not displayed!");
    }
    app.getGroupHelper().returnGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before, after);
    app.getSessionHelper().logout();
  }
}
