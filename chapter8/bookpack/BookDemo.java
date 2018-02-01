// A short package demonstration
package bookpack;

class Book {
  private String title;
  private String author;
  private int pubDate;

  Book(String t, String a, int d) {
    this.title = t;
    this.author = a;
    this.pubDate = d;
  }

  void show() {
    System.out.println(this.title);
    System.out.println(this.author);
    System.out.println(this.pubDate);
    System.out.println();
  }
}

class BookDemo {
  public static void main(String[] args) {
    Book[] books = new Book[5];

    books[0] = new Book("Java: A Beginners Guide", "Schildt", 2018);
    books[1] = new Book("Java: The Complete Reference", "Schildt", 2018);
    books[2] = new Book("Introducing JavaFX 8 Programming", "Schildt", 2015);
    books[3] = new Book("Red Storm Rising", "Clancy", 1986);
    books[4] = new Book("On the Road", "Kerouac", 1955);

    for (int i = 0; i < books.length; i++) {
      books[i].show();
    }
  }
}
