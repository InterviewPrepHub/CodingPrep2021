package Queue;

/*
O(1) for all operations.
 */
public class ImplementQueueUsingArray {

    private int[] arr;
    private int capacity;   // max no of elements a queue can hold
    private int size;  // current no of elements in the arr
    private int front; // keeps track of index of the front element in the queue. front is where next element is dequeued from
    private int rear;  // keeps track of index of last element in the queue. rear is where next element is enqueued in.

    public ImplementQueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    /*

    Circular queue:
    In an array-based queue, using the modulo operation ensures that the rear and front indices wrap
    around to the start of the array when they reach the end.

    Simply incrementing rear or front without the modulo operation would eventually lead to index
    out-of-bounds errors when the indices exceed the array length.

     */
    public void enqueue(int x) {
        if(isFull()) {
            System.out.println("queue is full for new element : "+x);
            return;
        }

        rear = (rear+1) % capacity;
        arr[rear] = x;
        size++;
    }

    public int dequeue() {
        if(isEmpty()) {
            return -1;
        }
        //get the front element from array
        int element = arr[front];

        //update the front of queue
        front = (front+1) % capacity;
        size--;

        return element;
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return arr[front];

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        ImplementQueueUsingArray queue = new ImplementQueueUsingArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(1);
        queue.enqueue(6);

        System.out.println("Dequeued: " + queue.dequeue()); //
        System.out.println("Front element: " + queue.peek());

        queue.enqueue(50);
        queue.enqueue(60);

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

    }

    private void printQueue() {
        for (int i= front;i<= rear;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
