import java.io.*;

class Help {
  String helpfile; // name of the help file.

  Help(String filename) {
    this.helpfile = filename;
  }

  // Display help on topic.
  boolean helpOn(String what) {
    int ch;
    String topic, info;

    // Open the help file.
    try (BufferedReader helpRdr = new BufferedReader(new FileReader(this.helpfile))) {
      do {
        // Read characters until a # is found.
        ch = helpRdr.read();

        // Now see if topics match.
        if (ch == '#') {
          topic = helpRdr.readLine();
          if (what.compareTo(topic) == 0) { // found topic.
            do {
              info = helpRdr.readLine();
              if (info != null) {
                System.out.println(info);
              }
            } while ((info != null) && (info.compareTo("") != 0));
            return true;
          }
        }
      } while (ch != -1);
    } catch (IOException exc) {
      System.out.println("Error accessing help file.");
      return false;
    }
    return false; // topic not found.
  }

  // Get a help topic.
  String getSelection() {
    String topic = "";

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter topic: ");
    try {
      topic = br.readLine();
    } catch (IOException exc) {
      System.out.println("Error reading console.");
    }
    return topic;
  }
}

// Demonstrate the file-based help system.
class FileHelp {
  public static void main(String[] args) {
    Help hlpObj = new Help("helpfile.txt");
    String topic;

    System.out.println("Try the help system. Enter 'stop' to end.");
    do {
      topic = hlpObj.getSelection();

      if (!hlpObj.helpOn(topic)) {
        System.out.println("Topic not found.\n");
      }
    } while (topic.compareTo("stop") != 0);
  }
}
