import java.util.ArrayList;
import java.util.Arrays;

public class TextUI {

  private ClippingManager clippingManager;

  public TextUI(ClippingManager clippingManager) {
    this.clippingManager = clippingManager;
  }

  public void start() {
    ArrayList<String> data = new ArrayList<>();
    data.add("\uFEFFThe Pragmatic Programmer (Ephriam J Daniels' Library) (Dave Thomas, Andy Hunt)");
    data.add("- 位置No. 422-423のハイライト |作成日: 2022年5月28日土曜日 13:21:54");
    data.add("");
    data.add("People find it easier to join an ongoing success. Show them a glimpse of the future and you’ll get them to rally around.");
    data.add("==========");
    data.add("無職転生 ～異世界行ったら本気だす～ 1 (MFブックス) (理不尽な孫の手)");
    data.add("- 位置No. 1522-1522のハイライト |作成日: 2022年5月8日日曜日 20:13:30");
    data.add("");
    data.add("大きい奴の顔面に命中。");
    data.add("==========");
    ArrayList<Clipping> finalClippings = new ArrayList<>();

    for (int i = 0; i < data.size(); i = i + 5) {
      //FIRST LINE: get BookName and Author:
      String[] parts = data.get(i).split("\\(");
      String author = parts[2];
      String bookName = parts[0];
      author = author.replaceAll("\\)", "");

      //SECOND LINE: get Date and Time:
      String[] parts2 = data.get(i + 1).split(" ");
      String creationDate = parts2[4].trim();
      String creationTime = parts2[5].trim();


      //FOURTH LINE: get ClippingText:
      String clippingText = data.get(i + 3).trim();

      //Create clipping object and add to list:
      Clipping clipping = new Clipping(bookName, author, creationDate, creationTime, clippingText);
      finalClippings.add(clipping);//In final code, add to hashmap instead, using clipping.getBookName() as KEY.
    }


    for (Clipping clip : finalClippings) {
      System.out.println("___________________________________________");
      System.out.println(clip);
      System.out.println("___________________________________________");
      System.out.println("");
    }


  }
}
