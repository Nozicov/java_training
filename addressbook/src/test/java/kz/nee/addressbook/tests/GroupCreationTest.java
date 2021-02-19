package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Group1", "Logo1", "Comment1"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupPage();
    app.getSessionHelper().logout();
  }

}
