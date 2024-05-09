package LinkedList;

public class DetectAndRemoveCycle {

    public static void main(String[] args) {
        DetectAndRemoveCycle s = new DetectAndRemoveCycle();

        NodeLL node = new NodeLL(10);
        node.next = new NodeLL(11);
        node.next.next = new NodeLL(12);
        node.next.next.next = new NodeLL(13);
        node.next.next.next.next = new NodeLL(14);
        node.next.next.next.next.next = new NodeLL(15);
        node.next.next.next.next.next.next = new NodeLL(16);

        node.next.next.next.next.next.next.next = node.next.next.next;

        System.out.println(s.detectCycle(node));
    }

    private boolean detectCycle(NodeLL node) {

        NodeLL slow = node;
        NodeLL fast = node;

        while(slow != null & fast != null& fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                removeLoop(slow, node);
                return true;
            }
        }

        return false;
    }

    /*
                                p1
                                p2
        10 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16
                          |_________________|

     */

    private void removeLoop(NodeLL slow, NodeLL node) {

        NodeLL p1 = slow;
        NodeLL p2 = slow;

//        count k number of nodes in the loop
        int k=1;
        while(p1.next != p2) {
            k++;
            p1 = p1.next;
        }

        System.out.println("no of nodes in loop : "+k);

        //move P2 through the list till k = 0
        p1 = node;
        p2 = node;
        while(k!=0) {
            k--;
            p2 = p2.next;
        }

        //find where p1 & p2 collide
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p2.next != p1) {
            p2 = p2.next;
        }
        p2.next = null;
    }
}
