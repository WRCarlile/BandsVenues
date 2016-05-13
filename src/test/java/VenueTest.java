import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class VenueTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Venue_instantiatesCorrectly_true() {
    Venue myVenue = new Venue("CBGBs", "555 Elm");
    assertEquals(true, myVenue instanceof Venue);
  }

  @Test
  public void getName_venueInstantiatesWithName_String() {
    Venue myVenue = new Venue("CBGBs", "555 Elm");
    assertEquals("CBGBs", myVenue.getName());
  }

  @Test
  public void getName_venueInstantiatesWithAddress_String() {
    Venue myVenue = new Venue("CBGBs", "555 Elm");
    assertEquals("555 Elm", myVenue.getAddress());
  }
  @Test
  public void all_emptyAtFirst_0() {
    assertEquals(0, Venue.all().size());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame_true() {
    Venue firstVenue = new Venue("CBGBs", "555 Elm");
    Venue secondVenue = new Venue("CBGBs", "555 Elm");
    assertTrue(firstVenue.equals(secondVenue));
  }

  @Test
  public void save_savesObjectIntoDatabase_true() {
    Venue myVenue = new Venue("CBGBs", "555 Elm");
    myVenue.save();
    assertTrue(Venue.all().get(0).equals(myVenue));
  }

  @Test
  public void save_assignsIdToObject_int() {
    Venue myVenue = new Venue("CBGBs", "555 Elm");
    myVenue.save();
    Venue savedVenue = Venue.all().get(0);
    assertEquals(myVenue.getId(), savedVenue.getId());
  }

  @Test
  public void find_findVenueInDatabase_true() {
    Venue myVenue = new Venue("CBGBs", "555 Elm");
    myVenue.save();
    Venue savedVenue = Venue.find(myVenue.getId());
    assertTrue(myVenue.equals(savedVenue));
  }
  // @Test
  // public void addBand_addsBandToVenue_true() {
  //   Venue myVenue = new Venue("CBGBs", "555 Elm");
  //   myVenue.save();
  //   Band myBand = new Band("Mow the lawn");
  //   myBand.save();
  //   myVenue.addBand(myBand);
  //   Band savedBand = myVenue.getBands().get(0);
  //   assertTrue(myBand.equals(savedBand));
  // }
  //
  // @Test
  // public void getBands_returnsAllBands_List() {
  //   Venue myVenue = new Venue("CBGBs", "555 Elm");
  //   myVenue.save();
  //   Band myBand = new Band("Mow the lawn");
  //   myBand.save();
  //   myVenue.addBand(myBand);
  //   List savedBands = myVenue.getBands();
  //   assertEquals(1, savedBands.size());
  // }
  //
  // @Test
  // public void delete_deletesAllBandsAndVenuesAssociations() {
  //   Venue myVenue = new Venue("CBGBs", "555 Elm");
  //   myVenue.save();
  //   Band myBand = new Band("Mow the lawn");
  //   myBand.save();
  //   myVenue.addBand(myBand);
  //   myVenue.delete();
  //   assertEquals(0, myBand.getVenues().size());
  // }

}
