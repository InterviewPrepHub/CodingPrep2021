package Stack;

public class ImplementStack {

    Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        return top.getData();
    }

    // o -> top is the new node
    // o node.next is the old top
    public void push(int data) {
        Node node = new Node(data, null);
        if (top!=null) {
            node.setNext(top); //node.next is going to point to the old top
            top=node; //new top is the node
        }
        top = node;
    }

    public int pop() {
        if (top == null) {
            return -1;
        }
        int data = top.getData();
        top = top.getNext();
        return data;
    }

    public static void main(String[] args) {
        ImplementStack s = new ImplementStack();
        System.out.println(s.isEmpty());
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}

class Node {
    private int data;
    private Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
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
