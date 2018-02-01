// A fixed-size queue class for characters
class FixedQueue implements ICharQ {
  private char[] q; // This array holds the queue
  private int putloc, getloc; // The put and get indices

  // Construct and empty queue given its size.
  public FixedQueue(int size) {
    this.q = new char[size]; // Allocate memory for queue

    this.putloc = this.getloc = 0;
  }

  // Put a character into the queue.
  public void put(char ch) {
    if (this.putloc == q.length) {
      System.out.println(" - Queue is full.");
      return;
    }
    this.q[this.putloc++] = ch;
  }

  // Get a character from the queue.
  public char get() {
    if (this.getloc == this.putloc) {
      System.out.println(" - Queue is empty.");
      return (char) 0;
    }
    return this.q[this.getloc++];
  }
}

// A circular queue.
class CircularQueue implements ICharQ {
  private char[] q; // This array holds the queue.
  private int putloc, getloc; // The put and get indices.

  // Construct an empty queue given its size.
  public CircularQueue(int size) {
    this.q = new char[size + 1]; // Allocate memory for queue.
    this.putloc = this.getloc = 0;
  }

  // Put a character into the queue.
  public void put(char ch) {
    /*  Queue is full if either putloc is one less than getloc, or
        if putloc is at the end of the array and getloc is at the
        beginning. */
    if (this.putloc + 1 == this.getloc | ((this.putloc == this.q.length - 1)
    & (this.getloc == 0))) {
      System.out.println(" - Queue is full.");
      return;
    }
    this.q[this.putloc++] = ch;
    if (this.putloc == this.q.length) this.putloc = 0; // Loop back
  }

  // Get a character from the queue
  public char get() {
    if (this.putloc == this.getloc) {
      System.out.println(" - Queue is empty.");
      return (char) 0;
    }

    char ch = this.q[this.getloc++];
    if (this.getloc == this.q.length) this.getloc = 0; // Loop back

    return ch;
  }
}

// A dynamic queue
class DynQueue implements ICharQ {
  private char[] q; // This array holds the queue.
  private int putloc, getloc; // The put and get indices.

  // Construct an empty queue given its size.
  public DynQueue(int size) {
    this.q = new char[size]; // Allocate memory for queue.
    this.putloc = this.getloc = 0;
  }

  // Put a character into the queue.
  public void put(char ch) {
    if (this.putloc == this.q.length) {
      // Increase queue size.
      char[] t = new char[this.q.length * 2];

      // Copy elements into new queue.
      for (int i = 0; i < this.q.length; i++) {
        t[i] = this.q[i];
      }
      this.q = t;
    }
    this.q[this.putloc++] = ch;
  }

  // Get a character from the queue.
  public char get() {
    if (this.getloc == this.putloc) {
      System.out.println(" - Queue is empty.");
      return (char) 0;
    }
    return this.q[this.getloc++];
  }
}

// Demonstrate the ICharQ interface.
class IQDemo {
  public static void main(String args[]) {
    FixedQueue q1 = new FixedQueue(10);
    DynQueue q2 = new DynQueue(5);
    CircularQueue q3 = new CircularQueue(10);

    ICharQ iQ;

    char ch;
    int i;

    iQ = q1;
    // Put some characters into fixed queue.
    for(i=0; i < 10; i++)
      iQ.put((char) ('A' + i));

    // Show the queue.
    System.out.print("Contents of fixed queue: ");
    for(i=0; i < 10; i++) {
      ch = iQ.get();
      System.out.print(ch);
    }
    System.out.println();

    iQ = q2;
    // Put some characters into dynamic queue.
    for(i=0; i < 10; i++)
      iQ.put((char) ('Z' - i));

    // Show the queue.
    System.out.print("Contents of dynamic queue: ");
    for(i=0; i < 10; i++) {
      ch = iQ.get();
      System.out.print(ch);
    }

    System.out.println();

    iQ = q3;
    // Put some characters into circular queue.
    for(i=0; i < 10; i++)
      iQ.put((char) ('A' + i));

    // Show the queue.
    System.out.print("Contents of circular queue: ");
    for(i=0; i < 10; i++) {
      ch = iQ.get();
      System.out.print(ch);
    }

    System.out.println();

    // Put more characters into circular queue.
    for(i=10; i < 20; i++)
      iQ.put((char) ('A' + i));

    // Show the queue.
    System.out.print("Contents of circular queue: ");
    for(i=0; i < 10; i++) {
      ch = iQ.get();
      System.out.print(ch);
    }

    System.out.println("\nStore and consume from" +
                       " circular queue.");

    // Use and consume from circular queue.
    for(i=0; i < 20; i++) {
      iQ.put((char) ('A' + i));
      ch = iQ.get();
      System.out.print(ch);
    }
    System.out.println();
  }
}
