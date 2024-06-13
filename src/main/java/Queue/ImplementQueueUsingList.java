package Queue;

import java.util.LinkedList;

/*
With linkedlist we dont need to handle circular nature manually since the linkedlist dynamically resizes.
O(1) for all operations.
 */
public class ImplementQueueUsingList<T> {

    private LinkedList<T> queue;

    public ImplementQueueUsingList() {
        queue = new LinkedList<>();
    }

    public void enqueue(T x) {
        queue.addLast(x);
    }

    public T dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue.removeFirst();
    }

    public T peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue.getFirst();

    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    //get the size of queue
    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        ImplementQueueUsingList q = new ImplementQueueUsingList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("dequeued : "+q.dequeue());
        System.out.println("front element : "+q.peek());
        q.enqueue(40);

        while (!q.isEmpty()) {
            System.out.println("dequeued : "+q.dequeue());
        }
    }
}
