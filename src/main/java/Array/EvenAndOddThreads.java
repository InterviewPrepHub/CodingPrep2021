package Array;

public class EvenAndOddThreads {

    static int i=1;

    public static void main(String[] args) {
        EvenAndOddThreads threads = new EvenAndOddThreads();
        printEvenOrOdd(threads);
    }

    private static void printEvenOrOdd(EvenAndOddThreads threads) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <=10) {
                    try {
                        threads.printNumber(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<=10) {
                    try {
                        threads.printNumber(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    private synchronized void printNumber(String threadName) throws InterruptedException {

        if(threadName.equals("t1")) {
            if (i%2==1) {
                System.out.println(threadName+"-->"+i++);
                notify();
            }else {
                wait();
            }

        } else if(threadName.equals("t2")) {
            if (i%2==0) {
                System.out.println(threadName+"-->"+i++);
                notify();
            }else {
                wait();
            }
        }

    }

}
