package MultiThreading;

/**
 * Video explanation:
 * https://www.youtube.com/watch?v=6YLGGLkVR98&list=PLPtUyMfD0mNJG3KLm1Mqi8wdHNwZ9cwHM&index=2&ab_channel=InterviewWithBunny
 */

public class Restaurant {

    static class Kitchen implements Runnable {

        //this is when we extend Thread class
//    public void run() {
//        System.out.println("Order Taken");
//        prepare();
//    }

        static Object lock = new Object();
        public static void prepare() {
            synchronized(lock) {
                System.out.println("Food preparation : STARTED :");
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Food preparation : DONE");

            }
        }

        @Override
        public void run() {
            System.out.println("Order Taken");
            prepare();
        }
    }

    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
//        kitchen.start();  ---->  this is when Thread class is extended
        Thread t1 = new Thread(kitchen);
        t1.start();

        Kitchen kitchen1 = new Kitchen();
//        kitchen1.start();
        Thread t2 = new Thread(kitchen1);
        t2.start();

        Kitchen kitchen2 = new Kitchen();
//        kitchen2.start();
        Thread t3 = new Thread(kitchen2);
        t3.start();
    }

}

