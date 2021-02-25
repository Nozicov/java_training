package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("Group1", "Logo1", "Comment1"));if (! app.getContactHelper().isVisibleSuccessMessage()){
      Assert.fail("Successful contact modification message was not displayed!");
    }
    if (! app.getGroupHelper().isVisibleSuccessMessage()){
      Assert.fail("Successful group creation message was not displayed!");
    }
    app.getGroupHelper().returnGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
    app.getSessionHelper().logout();
  }

}
