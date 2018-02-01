/* Display a text file

  To use this program, specify the name
  of the file that you want to see.
  For example, to see a file called TEST.TXT,
  use the following the command line.

  java ShowFile TEST.TXT
*/
import java.io.*;

class ShowFile {
  public static void main(String[] args) {
    int i;
    FileInputStream fin = null;

    // First make sure that a file has been specified.
    if (args.length != 1) {
      System.out.println("Usage: showFile File");
      return;
    }

    // The following code opens a file, reads characters until EOF
    // is encountered, and then closes the file via a finally block.
    try {
      fin = new FileInputStream(args[0]);

      do {
        i = fin.read();
        if (i != -1) {
          System.out.print((char) i);
        }
      } while (i != -1);
    } catch (FileNotFoundException exc) {
      System.out.println("File Not Found");
    } catch (IOException exc) {
      System.out.println("An I/O Error Occured");
    } finally {
      // Close file in all cases
      try {
        if (fin != null) fin.close();
      } catch (IOException exc) {
        System.out.println("Error closing file.");
      }
    }
  }
}
