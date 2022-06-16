public class Clipping {
  private String bookName;
  private String author;
  private String creationDate;
  private String creationTime;
  private String clippingText;

  public Clipping(String bookName, String author, String creationDate, String creationTime, String clippingText) {
    this.bookName = bookName;
    this.author = author;
    this.creationDate = creationDate;
    this.creationTime = creationTime;
    this.clippingText = clippingText;
  }


  public String toString() {
    return ("Book Name    : " + this.bookName +
            "\nAuthor       : " + this.author +
            "\nCreation Date: " + this.creationDate +
            "\nCreation Time: " + this.creationTime +
            "\nClippint Text: " + this.clippingText);
  }

  public String getBookName() {
    return bookName;
  }

  public String getAuthor() {
    return author;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public String getCreationTime() {
    return creationTime;
  }

  public String getClippingText() {
    return clippingText;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public void setCreationTime(String creationTime) {
    this.creationTime = creationTime;
  }

  public void setClippingText(String clippingText) {
    this.clippingText = clippingText;
  }


}
