// Create a thread by implementing Runnable
class MyThread implements Runnable {
  String thrdName;

  MyThread(String name) {
    thrdName = name;
  }

  // Entry point of thread
  public void run() {

  }
}

class UseThreads {
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
