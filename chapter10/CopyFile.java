/*  Copy a text file.
    To use this program, specifiy the name
    of the source file and the destination file.
    For example, to copy a file called FIRST.txt
    to a file called SECOND.txt, use the following
    command line.

    java CopyFile FIRST.txt SECOND.txt
*/
import java.io.*;

class CopyFile {
  public static void main(String[] args) {
    int i;
    FileInputStream fin = null;
    FileOutputStream fout = null;

    // First, make sure both files have been specified.
    if (args.length != 2) {
      System.out.println("Usage: CopyFile from to");
      return;
    }

    // Copy a file.
    try {
      // Attempt to open the files.
      fin = new FileInputStream(args[0]);
      fout = new FileOutputStream(args[1]);

      do {
        i = fin.read();

        if (i != -1) fout.write(i);
      } while (i != -1);
    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    } finally {
      try {
        if (fin != null) fin.close();
      } catch (IOException exc) {
        System.out.println("Error closing input file.");
      }

      try {
        if (fout != null) fout.close();
      } catch (IOException exc) {
        System.out.println("Error closing output file.");
      }
    }
  }
}
