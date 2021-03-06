import org.sql2o.*;
import org.junit.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.junit.Assert.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Band Tracker");
  }

  @Test
  public void venueIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Venues"));
    fill("#venueName").with("CBGBs");
    fill("#address").with("555 Elm");
    submit(".btn");
    assertThat(pageSource()).contains("CBGBs");
  }

  @Test
  public void bandIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Bands"));
    fill("#band_name").with("The Beatles");
    fill("#genre").with("Rock");
    submit(".btn");
    assertThat(pageSource()).contains("The Beatles");
  }

  @Test
  public void venueShowPageDisplaysName() {
    Venue testVenue = new Venue("CBGBs", "555 Elm");
    testVenue.save();
    String url = String.format("http://localhost:4567/venues/%d", testVenue.getId());
    goTo(url);
    assertThat(pageSource()).contains("CBGBs");
  }

  @Test
  public void bandShowPageDisplaysBandName() {
    Band testBand = new Band("The Beatles", "Rock");
    testBand.save();
    String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
    goTo(url);
    assertThat(pageSource()).contains("The Beatles");
  }

  // @Test
  // public void bandIsAddedToVenue() {
  //   Venue testVenue = new Venue("CBGBs", "555 Elm");
  //   testVenue.save();
  //   Band testBand = new Band("The Beatles", "Rock");
  //   testBand.save();
  //   String url = String.format("http://localhost:4567/venues/%d", testVenue.getId());
  //   goTo(url);
  //   fill("#band_id", with("checkbox").with("The Beatles"));
  //   submit("#selectBand");
  //   assertThat(pageSource()).contains("<li>");
  //   assertThat(pageSource()).contains("The Beatles");
  // }

  @Test
  public void venueIsAddedToBand() {
    Venue testVenue = new Venue("CBGBs", "555 Elm");
    testVenue.save();
    Band testBand = new Band("The Beatles", "Rock");
    testBand.save();
    String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
    goTo(url);
    fillSelect("#venue_id").withText("CBGBs");
    submit("#addVenue");
    assertThat(pageSource()).contains("<li>");
    assertThat(pageSource()).contains("CBGBs");
  }
  @Test
  public void bandBandNameIsUpdated() {
    Band testBand = new Band("The Beatles", "Rock");
    testBand.save();
    String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
    goTo(url);
    click("a", withText("Edit this band"));
    fill("#newBandName").with("The Rolling Stones", "Roll");
    submit(".btn");
    goTo(url);
    assertThat(pageSource()).contains("The Rolling Stones");
  }

  @Test
  public void bandIsDeleted() {
    Band testBand = new Band("The Beatles", "Rock");
    testBand.save();
    String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
    goTo(url);
    submit("#delete");
    goTo(url);
    assertThat(pageSource()).contains("$band.getBandName()");
  }
}
