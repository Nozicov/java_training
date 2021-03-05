package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import kz.nee.addressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().groupPage();

    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Test group");
    app.group().create(group);
    Groups after = app.group().all();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));
  }

}
