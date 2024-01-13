package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingSingleQueue {

    Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        ImplementStackUsingSingleQueue s = new ImplementStackUsingSingleQueue();

        s.q.add(10);
        s.q.add(11);
        s.push(12);

    }

    public void push(int data) {
        //get previous size of queue
        int size = q.size();    //2
        q.add(data);    //10,11,12

        for (int i=0;i<size;i++) {
            int val = q.poll(); //10,11
            q.add(val); //11,12,10    12,10,11
        }
    }

    public int pop() {
        if (!q.isEmpty()) {
            return q.remove();
        }
        return -1;
    }

    public int peek() {
        if (!q.isEmpty()) {
            return q.remove();
        }
        return -1;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
