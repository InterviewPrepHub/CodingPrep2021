package LinkedList;

import java.util.PriorityQueue;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class MergeKList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(5);

        ListNode[] nodeArr = {node1, node2};

        ListNode node = mergeKList(nodeArr);

        printLinkedList(node);


    }

    public static ListNode mergeKList(ListNode[] list) {   //[1->3->4, 1->4->5, 2->6]
       PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
       for (ListNode head: list) {
           while (head!=null) {
               minHeap.add(head.data);
               head = head.next;
           }
       }

        System.out.println(minHeap);

//       while (!minHeap.isEmpty()) {
//           System.out.println(minHeap.poll());
//       }

       ListNode dummy = new ListNode(-1);
       ListNode head = dummy;
       while (!minHeap.isEmpty()) {
           head.next = new ListNode(minHeap.poll());
           head = head.next;
       }

       return dummy.next;
    }

    private static void printLinkedList(ListNode node) {
        while (node.next!=null) {
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.print(node.data);
    }
}
