package LinkedList;

public class AddLastInLinkedList {

    NodeLL head;
    NodeLL tail;

    public static void main(String[] args) {
        AddLastInLinkedList a = new AddLastInLinkedList();
        a.add(10);
        a.add(11);
        a.add(12);
        a.add(13);
        a.add(14);
        a.add(15);
        a.add(16);
        a.addLast(17);

        a.print();
    }

    private void print() {
        NodeLL node = head;
        while (node.next != null) {
            node = node.next;
            System.out.println(node.data);
        }
    }

    private void add(int data) {
        NodeLL node = new NodeLL(data);
        if(tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    private void addLast(int data) {
        NodeLL nodeToAdd = new NodeLL(data);
        NodeLL nodeToTravese = head;
        while (nodeToTravese.next!=null) {
            nodeToTravese = nodeToTravese.next;
        }
        nodeToTravese.next = nodeToAdd;
    }
}
