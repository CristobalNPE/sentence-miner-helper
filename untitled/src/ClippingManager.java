import javax.sound.sampled.Clip;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ClippingManager {
  private Map<String, List<Clipping>> clippings;

  public ClippingManager() {

    this.clippings = new HashMap<>();
  }

  public void getClipsFromFile(String fileRoute) {
    List<String> clippings = new ArrayList<>();

    //Put the file in a temporary arraylist;
    try {
      clippings = Files.readAllLines(Paths.get(fileRoute));
    } catch (Exception e) {
      System.out.println("Error reading file :" + e);
    }


    for (int i = 0; i < clippings.size(); i = i + 5) {
      //FIRST LINE: get BookName and Author:
      String[] parts = clippings.get(i).split("\\(");
      String author = "";
      if (parts.length == 3) {
        author = parts[2];
      } else {
        author = parts[1];

      }
      author = author.replaceAll("\\)", "");
      String bookName = parts[0];
      bookName = bookName.replaceAll("\uFEFF", ""); //This  uFEFF code was messing everything up, removing it solved it.
      bookName = bookName.trim();


      //SECOND LINE: get Date and Time:
      String[] parts2 = clippings.get(i + 1).split(" ");
      String creationDate = parts2[4].trim();
      String creationTime = parts2[5].trim();


      //FOURTH LINE: get ClippingText:
      String clippingText = clippings.get(i + 3).trim();

      //Create clipping object with data obtained:
      Clipping clipping = new Clipping(bookName, author, creationDate, creationTime, clippingText);


      if (this.clippings.containsKey(clipping.getBookName())) {
        this.clippings.get(clipping.getBookName()).add(clipping);
      } else {
        List<Clipping> tempList = new ArrayList<>();
        tempList.add(clipping);
        this.clippings.putIfAbsent(clipping.getBookName(), tempList);
      }

    }
  }

  public void printAllClippings() {
    System.out.println("Books Found: ");
    for (String title : this.clippings.keySet()) {
      System.out.println(title);
    }
    System.out.println("=======================");
    System.out.println("Clipping amount: " + this.clippings.values().size());
    System.out.println("Printing clips: \n");
    for (List<Clipping> clips : this.clippings.values()) {
      for (Clipping clip : clips) {
        System.out.println("-------------");
        System.out.println(clip);
        System.out.println("-------------");
      }
    }
  }

  public void printOneBookClips(String name) {
    System.out.println("FOUND: " + this.clippings.get(name).size() + " clippings for " + name);
    for (Clipping clip : this.clippings.get(name)) {
      System.out.println("-------------");
      System.out.println(clip);
      System.out.println("-------------");
    }
  }

  public void displayAvailableClippings() {
    int index = 1;
    System.out.println("Found " + this.clippings.keySet().size() + " books with clippings: ");
    for (String title : this.clippings.keySet()) {
      System.out.println(index + ".- " + title);
      index++;
    }
  }


}
