import java.io.*;

class EnhancedCompFiles {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("You must provide two file names.");
      return;
    }

    int i = 0, j = 0;

    try (FileInputStream f1 = new FileInputStream(args[0]);
         FileInputStream f2 = new FileInputStream(args[1])) {
      do {
        f1.read();
        f2.read();
        if (i != j) break;
      } while (i != -1 && j != -1);

      if (i != j) {
        System.out.println("Files differ.");
      }
    } catch (IOException e) {
      System.out.println("Error reading or opening file.");
    }
  }
}
