package LinkedList;

import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(3);

        PriorityQueue<Integer> minHeap = new PriorityQueue();

        while(l1!=null) {
            minHeap.add(l1.data);
            l1 = l1.next;
        }

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
