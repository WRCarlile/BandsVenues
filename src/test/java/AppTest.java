// import org.sql2o.*;
// import org.junit.*;
// import org.fluentlenium.adapter.FluentTest;
// import org.junit.ClassRule;
// import org.junit.Test;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.htmlunit.HtmlUnitDriver;
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.fluentlenium.core.filter.FilterConstructor.*;
// import static org.junit.Assert.*;
//
// public class AppTest extends FluentTest {
//   public WebDriver webDriver = new HtmlUnitDriver();
//
//   @Override
//   public WebDriver getDefaultDriver() {
//     return webDriver;
//   }
//
//   @ClassRule
//   public static ServerRule server = new ServerRule();
//
//   @Rule
//   public DatabaseRule database = new DatabaseRule();
//
//   @Test
//   public void rootTest() {
//     goTo("http://localhost:4567/");
//     assertThat(pageSource()).contains("Todo list!");
//   }
//
//   @Test
//   public void venueIsCreatedTest() {
//     goTo("http://localhost:4567/");
//     click("a", withText("Venues"));
//     fill("#name").with("Household chores");
//     submit(".btn");
//     assertThat(pageSource()).contains("Household chores");
//   }
//
//   @Test
//   public void bandIsCreatedTest() {
//     goTo("http://localhost:4567/");
//     click("a", withText("Bands"));
//     fill("#band_name").with("Mow the lawn");
//     submit(".btn");
//     assertThat(pageSource()).contains("Mow the lawn");
//   }
//
//   @Test
//   public void venueShowPageDisplaysName() {
//     Venue testVenue = new Venue("Household chores");
//     testVenue.save();
//     String url = String.format("http://localhost:4567/venues/%d", testVenue.getId());
//     goTo(url);
//     assertThat(pageSource()).contains("Household chores");
//   }
//
//   @Test
//   public void bandShowPageDisplaysBandName() {
//     Band testBand = new Band("Mow the lawn");
//     testBand.save();
//     String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
//     goTo(url);
//     assertThat(pageSource()).contains("Mow the lawn");
//   }
//
//   @Test
//   public void bandIsAddedToVenue() {
//     Venue testVenue = new Venue("Household chores");
//     testVenue.save();
//     Band testBand = new Band("Mow the lawn");
//     testBand.save();
//     String url = String.format("http://localhost:4567/venues/%d", testVenue.getId());
//     goTo(url);
//     fillSelect("#band_id").withText("Mow the lawn");
//     submit("#selectBand");
//     assertThat(pageSource()).contains("<li>");
//     assertThat(pageSource()).contains("Mow the lawn");
//   }
//
//   @Test
//   public void venueIsAddedToBand() {
//     Venue testVenue = new Venue("Household chores");
//     testVenue.save();
//     Band testBand = new Band("Mow the lawn");
//     testBand.save();
//     String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
//     goTo(url);
//     fillSelect("#venue_id").withText("Household chores");
//     submit("#addVenue");
//     assertThat(pageSource()).contains("<li>");
//     assertThat(pageSource()).contains("Household chores");
//   }
//   @Test
//   public void bandBandNameIsUpdated() {
//     Band testBand = new Band("Mow the lawn");
//     testBand.save();
//     String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
//     goTo(url);
//     click("a", withText("Edit this band"));
//     fill("#band_name").with("Go out dancing");
//     submit(".btn");
//     goTo(url);
//     assertThat(pageSource()).contains("Go out dancing");
//   }
//
//   @Test
//   public void bandIsDeleted() {
//     Band testBand = new Band("Mow the lawn");
//     testBand.save();
//     String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
//     goTo(url);
//     submit("#delete");
//     goTo(url);
//     assertThat(pageSource()).contains("$band.getBandName()");
//   }
// }
