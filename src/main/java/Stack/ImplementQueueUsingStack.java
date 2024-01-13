package Stack;

import java.util.Stack;

public class ImplementQueueUsingStack {

    /*
    functionalities -> isEmpty(), peek(), enQueue(), dequeue()
    we need to use 2 stacks
    queue -> first in first out -> so if 1 is added to stack, it should be on the top
     */

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /*
        s1      s2

        30
        20
        10
     */

    public void enQueue(int x) {    //10, 20, 30
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int deQueue() {
        if (s1.isEmpty()) {
            System.out.println("stack is empty");
            System.exit(0);
        }
        int data = s1.peek();
        s1.pop();
        return data;
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack i = new ImplementQueueUsingStack();
        i.enQueue(10);
        i.enQueue(20);
        i.enQueue(30);

        System.out.println(i.deQueue());
    }
}
