import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;


public class BandTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Band_instantiatesCorrectly_true() {
    Band myBand = new Band("The Beatles", "Rock");
    assertEquals(true, myBand instanceof Band);
  }

  @Test
  public void getBandName_bandInstantiatesWithBandName_String() {
    Band myBand = new Band("The Beatles", "Rock");
    assertEquals("The Beatles", myBand.getBandName());
  }

  @Test
  public void all_emptyAtFirst_0() {
    assertEquals(0, Band.all().size());
  }

  @Test
  public void equals_returnsTrueIfBandNamesAretheSame_true() {
    Band firstBand = new Band("The Beatles", "Rock");
    Band secondBand = new Band("The Beatles", "Rock");
    assertTrue(firstBand.equals(secondBand));
  }

//   @Test
//   public void save_savesObjectIntoDatabase_true() {
//     Band myBand = new Band("The Beatles", "Rock");
//     myBand.save();
//     assertTrue(Band.all().get(0).equals(myBand));
//   }
//
//   @Test
//   public void save_assignsIdToObject_int() {
//     Band myBand = new Band("The Beatles", "Rock");
//     myBand.save();
//     Band savedBand = Band.all().get(0);
//     assertEquals(myBand.getId(), savedBand.getId());
//   }
//
//   @Test
//   public void find_findsBandInDatabase_true() {
//     Band myBand = new Band("The Beatles", "Rock");
//     myBand.save();
//     Band savedBand = Band.find(myBand.getId());
//     assertTrue(myBand.equals(savedBand));
//   }
//
//   @Test
//   public void update_updatesBandBandName_true() {
//     Band myBand = new Band("The Beatles", "Rock");
//     myBand.save();
//     myBand.update("Take a nap");
//     assertEquals("Take a nap", Band.find(myBand.getId()).getBandName());
//   }
//
//   @Test
//   public void delete_deletesBand_true() {
//     Band myBand = new Band("The Beatles", "Rock");
//     myBand.save();
//     int myBandId = myBand.getId();
//     myBand.delete();
//     assertEquals(null, Band.find(myBandId));
//   }
//
//   @Test
//   public void addVenue_addsVenueToBand() {
//     Venue myVenue = new Venue("Household chores");
//     myVenue.save();
//     Band myBand = new Band("The Beatles", "Rock");
//     myBand.save();
//     myBand.addVenue(myVenue);
//     Venue savedVenue = myBand.getVenues().get(0);
//     assertTrue(myVenue.equals(savedVenue));
//   }
//
//   @Test
//   public void getVenues_returnsAllVenues_List() {
//     Venue myVenue = new Venue("Household chores");
//     myVenue.save();
//     Band myBand = new Band("The Beatles", "Rock");
//     myBand.save();
//     myBand.addVenue(myVenue);
//     List savedVenues = myBand.getVenues();
//     assertEquals(1, savedVenues.size());
//   }
//
//   @Test
//   public void delete_deletesAllBandsAndVenuesAssociations() {
//     Venue myVenue = new Venue("Household chores");
//     myVenue.save();
//     Band myBand = new Band("The Beatles", "Rock");
//     myBand.save();
//     myBand.addVenue(myVenue);
//     myBand.delete();
//     assertEquals(0, myVenue.getBands().size());
//   }
//
//
}
