package Queue;

import java.util.Stack;

/*
use two stacks
stack 1 : used for enqueuing elements
stack 2 : used for dequeuing elements

O(1) for enqueue, O(n) for dequeue and peek in the worst case, O(1) for isEmpty.
 */
public class ImplementQueueUsingStacks<T> {

    Stack<T> stack1;
    Stack<T> stack2;

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T x) {
        stack1.push(x);
    }

    public T dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return null; // or throw an exception
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public T peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return null; // or throw an exception
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }


    public boolean isEmpty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks q = new ImplementQueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue());  // Dequeued: 10
        System.out.println("Front element: " + q.peek()); // Front element: 20

        q.enqueue(40);

        while (!q.isEmpty()) {
            System.out.println("Dequeued : "+q.dequeue());
        }

    }
}
