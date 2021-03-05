package kz.nee.addressbook.tests;

import kz.nee.addressbook.model.GroupData;
import kz.nee.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("Test group").withHeader("Text heater").withFooter("Text footer"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {

    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();

    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }

}
