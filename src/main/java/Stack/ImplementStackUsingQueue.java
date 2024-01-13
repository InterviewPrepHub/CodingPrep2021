package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    int curr_size=0;

    public void push(int x) {
        curr_size++;

        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        //swap names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public void pop() {
        if (q1.isEmpty()) {
            return;
        }
        q1.remove();
        curr_size--;
    }

    public static void main(String[] args) {

    }
}
