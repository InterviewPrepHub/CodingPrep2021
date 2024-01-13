package Queue;

public class ImplementQueue {

    Node head;
    Node tail;

    public boolean isEmpty() {
        if (head==null) {
            return true;
        }
        return false;
    }

    public int peek() {
        return head.getData();
    }

    public void enQueue(int data) {
        Node node = new Node(data, null);
        if (tail!=null) {
            tail.setNext(node);
        }
        tail = node;
        if (head==null) {
            head = node;
        }
    }

    public int deQueue() {
        //in order to deQueue, remove data from head
        int data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public static void main(String[] args) {
        ImplementQueue q = new ImplementQueue();
        System.out.println(q.isEmpty());
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        System.out.println(q.peek());
        System.out.println(q.deQueue());
        System.out.println(q.peek());
    }

}

class Node {
    private int data;
    private Node next;

    Node(int data, Node node) {
        this.data = data;
        this.next = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
