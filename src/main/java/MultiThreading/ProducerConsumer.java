package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Object key = new Object();
        int capacity = 6;

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    synchronized (key) {
                        try {
                            while(queue.size()==capacity) {
                                key.wait();
                            }
                            queue.offer(count++);
                            key.notifyAll();
                            Thread.sleep(1000);
                            System.out.println("MOMO produced, plate size : "+queue.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (key) {
                        try {
                            while (queue.size() == 0) {
                                key.wait();
                            }
                            queue.poll();
                            key.notifyAll();
                            Thread.sleep(800);
                            System.out.println("MOMO consumed, plate size : "+queue.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
