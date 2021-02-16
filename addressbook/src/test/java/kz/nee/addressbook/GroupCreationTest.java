package kz.nee.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Group1", "Logo1", "Comment1"));
    submitGroupCreation();
    returnGroupPage();
    logout();
  }

}
