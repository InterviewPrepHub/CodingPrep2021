package MultiThreading;

/**
 * Print even and odd numbers in increasing orderusing two threads in java
 */
class Print implements Runnable {

    static int counter = 1;
    static Object key = new Object();
    int reminder;

    Print(int reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
        for (int i=1;i<=5;i++) {
            synchronized (key) {
                while (counter%2!=reminder) {
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printer();
//                System.out.println(Thread.currentThread().getName()+"  "+i);
                key.notifyAll();
            }
        }
    }

    public void printer() {
        System.out.println(Thread.currentThread().getName()+"  "+counter++);
    }
}

public class PrintEvenAndOdd {

    public static void main(String[] args) {

        Print evenObj = new Print(0);
        Print oddObj = new Print(1);

        Thread even = new Thread(evenObj, "Even");

        Thread odd = new Thread(oddObj, "Odd");

        even.start();
        odd.start();
    }

}
