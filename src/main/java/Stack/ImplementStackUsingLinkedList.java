package Stack;

public class ImplementStackUsingLinkedList {

    Node tail = new Node(0,null);
    Node head = new Node(0,tail);

    public static void main(String[] args) {

        ImplementStackUsingLinkedList s = new ImplementStackUsingLinkedList();

        s.push(10);
        s.push(11);
        s.push(12);
    }

    public void push(int data) {
        Node nodeToAdd = new Node(data, null);
        if(tail == null) {
            head.setNext(nodeToAdd);
            nodeToAdd.setNext(tail);
        } else {
            addToHead(nodeToAdd);
        }

    }

    private void addToHead(Node nodeToAdd) {
        nodeToAdd.setNext(head.getNext());
        head.setNext(nodeToAdd);
    }

    public int pop() {
        Node node = head.getNext();
        head.setNext(node.getNext());
        return node.getData();
    }

//    public int peek() {
//
//    }

    public boolean isEmpty() {
        if(head.getNext().getData() == tail.getData()) {
            return true;
        }
        return false;
    }
}
