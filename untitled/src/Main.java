public class Main {
  public static void main(String[] args) {
    ClippingManager clippingManager = new ClippingManager();
    TextUI ui = new TextUI(clippingManager);
    ui.start();
  }
}
