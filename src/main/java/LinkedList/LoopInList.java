package LinkedList;

public class LoopInList {
    static NodeLL head;

    public static void main(String[] args) {
        head = new NodeLL(50);
        head.next = new NodeLL(20);
        head.next.next = new NodeLL(15);
        head.next.next.next = new NodeLL(4);
        head.next.next.next.next = new NodeLL(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        detectAndRemoveLoop(head);
        printList(head);
    }

    private static void printList(NodeLL node) {
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }

//    10->11->12->13->14
//            |_______|

    static int detectAndRemoveLoop(NodeLL node)
    {
        NodeLL slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeCycle(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop
    static void removeCycle(NodeLL loop, NodeLL head) {

//        loop = 13, head = 13
//        12 -> 13 -> 14
//         |__________|
        NodeLL ptr1 = loop;
        NodeLL ptr2 = loop;

        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Get pointer to the last node
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
    }
}
