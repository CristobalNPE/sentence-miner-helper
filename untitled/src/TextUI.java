public class TextUI {

  private Clippings clippings;

  public TextUI(Clippings clippings) {
    this.clippings = clippings;
  }

  public void start() {
    System.out.println("Reading clippings...");
    this.clippings.storeClippingsFromFile("untitled/My Clippings.txt");
    //this.clippings.printLines(3);
    //this.clippings.printClippingsWithStep(5);
    System.out.println("Titles found:");
    this.clippings.getTitlesOfClippings();
    this.clippings.printTitles();
  }
}
