package LinkedList;

public class SwapListNodesInPairs {

    public static void main(String[] args) {

        SwapListNodesInPairs s = new SwapListNodesInPairs();

        NodeLL node = new NodeLL(10);
        node.next = new NodeLL(11);
        node.next.next = new NodeLL(12);
        node.next.next.next = new NodeLL(13);
        node.next.next.next.next = new NodeLL(14);
        node.next.next.next.next.next = new NodeLL(15);
        node.next.next.next.next.next.next = new NodeLL(16);

        NodeLL n = s.swapInPairs(node);
        s.printLinkedList(n);
    }

    private NodeLL swapInPairs(NodeLL node) {

        while (node==null || node.next==null) {
            return node;
        }

        NodeLL p1 = node; //10
        NodeLL p2 = node.next;    //11
        NodeLL p3 = node.next.next;   //12

        node = p2;    //node = 11
        node.next = p1;  //11->10
        node.next.next = swapInPairs(p3);

        return node;
    }

    private static void printLinkedList(NodeLL node) {
        while (node.next!=null) {
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.print(node.data);
    }
}
