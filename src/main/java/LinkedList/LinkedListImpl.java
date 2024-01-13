package LinkedList;

class Node {
    int data;
    NodeLL next;

    Node(int data) {
        this.data = data;
    }
}

public class LinkedListImpl {
    static NodeLL head;
    static NodeLL tail;

    public static void main(String[] args) {
        LinkedListImpl l = new LinkedListImpl();
        l.add(10);
        l.add(11);
        l.add(5);
        l.add(9);
        l.add(13);
        l.add(23);
        l.add(20);

        System.out.println("Current Linked List: ");
        l.printLinkedList(head);
        System.out.println();

        System.out.println();
        System.out.println("find kth node from end");
        l.findKthNodeFromEnd(3);

        l.removeKthNodeFromEnd(3);

//        l.middleElementOfLinkedList(head);

        System.out.println();
        int n = l.linkedListLength(head);
        System.out.println("length of list : "+n);


        NodeLL head_node = head;

        System.out.println();
        System.out.println("Reverse linked list in groups of k: ");
        NodeLL node1 = l.reverseLinkedListInKGroups(head, 3);
        printLinkedList(node1);

        System.out.println();
        System.out.println("Rotate linked list : ");
        l.rotateLinkedList(head_node,2);

        System.out.println();
        l.reverseLinkedList(head_node);

    }

    //10 -> 11 -> 5 -> 9 -> 13 -> 23 -> 20
    private void findKthNodeFromEnd(int k) {
        NodeLL fast = head; //10
        NodeLL slow = head;

        for(int i=0; fast!=null && i<k; i++) {  //k = 3
            fast = fast.next;   //11, 5, 9
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.data);
    }

    //10 -> 11 -> 5 -> 9 -> 13 -> 23 -> 20
    private NodeLL removeKthNodeFromEnd(int k) {
        NodeLL fast = head;   //1
        NodeLL slow = head;   //1

        for(int i=0;i<k && fast != null;i++) {  //0,1,2
            fast = fast.next;   //2,3
        }

        if (fast != null) return slow.next;

        while(fast.next != null) {
            slow = slow.next;   //1,2,3
            fast = fast.next;   //4,5,null
        }

        slow.next = slow.next.next;

        return head;
    }

    private NodeLL reverseLinkedListInKGroups(NodeLL head_node, int k) {
        NodeLL node = head_node;
        int x = k;
        NodeLL p1 = null, p2 = null, p3 = node;
        while(p3!=null & x>0) {
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
            p2.next = p1;
            x--;
        }
        if (p3!=null) {
            head_node.next = reverseLinkedListInKGroups(p3,k);
        }
        return p2;
    }

    private void rotateLinkedList(NodeLL head, int k) {

        //10->11->5->9->13->23->20      k=2     n=5

        //11->10->5->9->13->23->20      k=2

        //11->10->20->23->13->9->5      n-k = 3

        //5->9->13->23->20->10->11      n=5

        //lengthOfLinkedList
        int n = linkedListLength(head);

        //reverse first half before k
        NodeLL curr_head = rotateFirstHalfLinkedListUtil(head, k);

        //reverse second half before k
        NodeLL curr_list_head = rotateSecondHalfLinkedListUtil(curr_head, k);

        //reverse whole list
        rotateCompleteLinkedListUtil(curr_list_head, n);
    }

    private void rotateCompleteLinkedListUtil(NodeLL curr_list_head, int n) {

        NodeLL node = curr_list_head;
        NodeLL p1=null,p2=null,p3=node;
        //10->11->5

        while (p3!=null) {
            p1=p2;          //null,10,11
            p2=p3;          //10,11,5
            p3=p3.next;     //11,5,null
            p2.next = p1;   //10->null,11->10,5->11
        }
        curr_list_head = p2;
        printLinkedList(curr_list_head);
    }

    private NodeLL rotateSecondHalfLinkedListUtil(NodeLL head, int k) {
        NodeLL node = head;
        int l = k;
        while(k>0) {
            node = node.next;
            k--;
        }

        NodeLL p1=null,p2=null,p3=node;

//      10->11  ->5->9->13->23->20
        while (p3!=null) {
            p1=p2;          //null,
            p2=p3;          //5
            p3=p3.next;     //9
            p2.next = p1;   //5->null
        }

        NodeLL curr_node = head;
        while (l>1) {
            curr_node = curr_node.next;
            l--;
        }
        curr_node.next = p2;

        return head;
    }

    private NodeLL rotateFirstHalfLinkedListUtil(NodeLL head, int k) {

//        10->11  ->5->9->13->23->20
        NodeLL node = head;
        NodeLL p1=null,p2=null,p3=node;
        while(k>0) {
            p1=p2;          //null,10
            p2=p3;          //10,11
            p3=p3.next;     //11,5
            p2.next = p1;   //10->null,11->10->null
            k--;            //1
        }
        head = p2;
//        p1.next=p3;

        NodeLL curr_Node = head;
        while(curr_Node.next !=null) {
            curr_Node = curr_Node.next;
        }
        curr_Node.next = p3;

        return head;
    }


    private int linkedListLength(NodeLL head) {
        NodeLL node = head;
        int i=1;
        while (node.next!=null) {
            node = node.next;
            i++;
        }
        return i;
    }

    private static void reverseLinkedList(NodeLL head) {
        NodeLL node = head;
        NodeLL p1=null,p2=null,p3=node;
        //10->11->5

        while (p3!=null) {
            p1=p2;          //null,10,11
            p2=p3;          //10,11,5
            p3=p3.next;     //11,5,null
            p2.next = p1;   //10->null,11->10,5->11
        }
        head = p2;
        System.out.println();
        System.out.println("Reverse linked list : ");
        printLinkedList(node);
    }

    private void middleElementOfLinkedList(NodeLL node) {

        NodeLL slow=head, fast=head;
        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.data);
    }

    private static void printLinkedList(NodeLL node) {
        while (node.next!=null) {
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.print(node.data);
    }

    private void add(int data) {
        NodeLL new_node = new NodeLL(data);
        if (tail==null) {
            tail = new_node;
            head = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
    }
}


