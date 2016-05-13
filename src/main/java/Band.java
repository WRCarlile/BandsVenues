import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Band {
  private int id;
  private String band_name;
  private String genre;


  public Band(String band_name, String genre) {
    this.band_name = band_name;
    this.genre = genre;
  }

  public String getBandName() {
    return band_name;
  }

  public int getId() {
    return id;
  }

  public String getGenre(){
    return genre;
  }


  public static List<Band> all() {
    String sql = "SELECT id, band_name FROM bands";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Band.class);
    }
  }

  @Override
  public boolean equals(Object otherBand){
    if (!(otherBand instanceof Band)) {
      return false;
    } else {
      Band newBand = (Band) otherBand;
      return this.getBandName().equals(newBand.getBandName()) &&
             this.getId() == newBand.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO bands(band_name, genre) VALUES (:band_name, :genre)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("band_name", this.band_name)
        .addParameter("genre", this.genre)
        .executeUpdate()
        .getKey();
    }
  }

  public static Band find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM bands where id=:id";
      Band band = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Band.class);
      return band;
    }
  }

  public void update(String newBandName) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE bands SET band_name = :band_name WHERE id = :id";
      con.createQuery(sql)
        .addParameter("band_name", newBandName)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }


  public void addVenue(Venue venue) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO venues_bands (venue_id, band_id) VALUES (:venue_id, :band_id)";
      con.createQuery(sql)
        .addParameter("venue_id", venue.getId())
        .addParameter("band_id", this.getId())
        .executeUpdate();
    }
  }


  public List<Venue> getVenues(){
    try(Connection con = DB.sql2o.open()) {
      String joinQuery = "SELECT venue_id FROM venues_bands WHERE band_id = :band_id";
      List<Integer> venueIds = con.createQuery(joinQuery)
        .addParameter("band_id", this.getId())
        .executeAndFetch(Integer.class);


      List<Venue> venues = new ArrayList<Venue>();

      for (Integer venueId : venueIds) {
        String venueQuery = "Select * FROM venues WHERE id = :venueId";
        Venue venue = con.createQuery(venueQuery)
          .addParameter("venueId", venueId)
          .executeAndFetchFirst(Venue.class);
        venues.add(venue);
      }

      return venues;
    }
  }

  public void delete(){
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM bands WHERE id = :id;";
        con.createQuery(deleteQuery)
          .addParameter("id", this.getId())
          .executeUpdate();

      String joinDeleteQuery = "DELETE FROM venues_bands WHERE band_id = :bandId";
        con.createQuery(joinDeleteQuery)
          .addParameter("bandId", this.getId())
          .executeUpdate();
    }
  }

}
