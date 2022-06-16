public class TextUI {

  private Clippings clippings;

  public TextUI(Clippings clippings) {
    this.clippings = clippings;
  }

  public void start() {
    System.out.println("Reading clippings...");
    this.clippings.storeClippingsFromFile("untitled/My Clippings.txt");
    System.out.println("Printing clippings: ");
    this.clippings.printClippings();
  }
}
