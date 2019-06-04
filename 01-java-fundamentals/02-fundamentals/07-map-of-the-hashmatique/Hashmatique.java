import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
  public static void main(String[] args) {

    HashMap<String, String> trackList = new HashMap<String, String>();
    trackList.put("Old Alabama", "Play me some old Alabama");
    trackList.put("What Was I Thinkin", "Hit the honkey tonk");
    trackList.put("Planetary Go", "get up and go!");
    trackList.put("Hey Soul Sister", "Ain't that mister mister on the radio.");

    String song = trackList.get("Old Alabama");
    System.out.println(song);

    Set<String> keys = trackList.keySet();
    for (String key : keys) {
      System.out.println(key + ": " + trackList.get(key));
      // System.out.println(trackList.get(key));
    }
  }
}
