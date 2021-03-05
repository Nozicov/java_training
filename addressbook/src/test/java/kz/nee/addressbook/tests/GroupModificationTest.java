package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import kz.nee.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("Test group").withHeader("Text heater").withFooter("Text footer"));
    }
  }

  @Test
  public void testGroupModificationTest() throws Exception {

    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("Test group-up")
            .withHeader("Text heater-up")
            .withFooter("Text footer-up");
    app.group().modify(group);
    Groups after = app.group().all();

    assertEquals(before.size(), after.size());
    assertThat(after, equalTo(before.withModified(group, modifiedGroup)));
  }

}
