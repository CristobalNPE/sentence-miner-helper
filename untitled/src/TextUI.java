import java.util.ArrayList;
import java.util.Arrays;

public class TextUI {

  private ClippingManager clippingManager;

  public TextUI(ClippingManager clippingManager) {
    this.clippingManager = clippingManager;
  }

  public void start() {
    this.clippingManager.getClipsFromFile("untitled/My Clippings.txt");
    //this.clippingManager.printAllClippings();
    //this.clippingManager.printOneBookClips("Eloquent JavaScript");
    //this.clippingManager.displayAvailableClippings();
  }
}
