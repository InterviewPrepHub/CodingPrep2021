package Array;

public class TestThreads {

    public static void main(String[] args) {

        TestThreads test = new TestThreads();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.method();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.method();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    private void method() throws InterruptedException {
        System.out.println("access this method");
        wait();
    }
}
