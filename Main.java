package sample;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
          public void run() {
              new IHMTerminal().lance();
          }
        };

        Thread thread2 = new Thread() {
            public void run() {
                new IHMFX().lance();
            }
        };

        thread1.start();
        thread2.start();
    }
}
