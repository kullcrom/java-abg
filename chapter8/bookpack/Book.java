package bookpack;

public class Book {
  private String title;
  private String author;
  private int pubDate;

  public Book(String t, String a, int d) {
    this.title = t;
    this.author = a;
    this.pubDate = d;
  }

  public void show() {
    System.out.println(this.title);
    System.out.println(this.author);
    System.out.println(this.pubDate);
    System.out.println();
  }
}
