package LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ReverseLinkedList r = new ReverseLinkedList();

        NodeLL node = new NodeLL(10);
        node.next = new NodeLL(11);
        node.next.next = new NodeLL(12);
        node.next.next.next = new NodeLL(13);
        node.next.next.next.next = new NodeLL(14);
        node.next.next.next.next.next = new NodeLL(15);
        node.next.next.next.next.next.next = new NodeLL(16);

        NodeLL n1 = node;
        NodeLL res = r.reverse(node);

        printList(res);

        //reverse with window
        NodeLL res2 = r.reverseWindow(n1,3);

    }

    private static void printList(NodeLL node) {
        System.out.print(node.data+"->");
        while(node.next != null) {
            node = node.next;
            if(node.next == null) {
                System.out.println(node.data + "->"+null);
            } else {
                System.out.print(node.data + "->");
            }
        }
    }

    /*
        10 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16


        P1 = null, null,
        P2 = null, 10
        P3 = 10,   11

     */
    private NodeLL reverse(NodeLL node) {

        NodeLL p1 = null,p2 = null,p3 = node;
        while(p3!=null) {
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
            p2.next = p1;
        }
        node = p2;
        return node;
    }

    private NodeLL reverseWindow(NodeLL node, int k) {

        NodeLL head_node = node;
        NodeLL p1 = null, p2 = null, p3 = head_node;

        int n = k;
        while(p3!=null & n>0) {

            p1 = p2;
            p2 = p3;
            p3 = p3.next;
            p2.next = p1;
            n--;

        }

        if (p3!=null) {
            head_node.next = reverseWindow(p3, k);
        }
        return p2;
    }
}
