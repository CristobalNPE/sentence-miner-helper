import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Clippings {
  private List<String> clippings;

  public Clippings() {
    this.clippings = new ArrayList<>();
  }

  public void storeClippingsFromFile(String fileRoute) {
    try {
      this.clippings = Files.readAllLines(Paths.get(fileRoute));
    } catch (Exception e) {
      System.out.println("Error reading file :" + e);
    }
  }

  public void printClippings() {
    for (String clipping : this.clippings) {
      System.out.println(clipping);
    }
  }

}
