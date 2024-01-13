package LinkedList;

public class CloneLLWithRandomPointer {

    public static void main(String[] args) {

        RNode start = new RNode(1);
        start.next = new RNode(2);
        start.next.next = new RNode(3);
        start.next.next.next = new RNode(4);
        start.next.next.next.next = new RNode(5);

//          |---------|---------|
//          1 -> 2 -> 3 -> 4 -> 5
//                         |----|
//          |-----|-------------|

        // 1's random points to 3\
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random
                = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        RNode node = clone(start);

        print(node);

    }

    private static void print(RNode node) {
        RNode ptr = node;
        while (ptr != null) {
            System.out.println("Data : "+ptr.val +" with random ptr "+ptr.random.val);
            ptr = ptr.next;
        }
    }

    private static RNode clone(RNode start) {

        RNode curr = start;
        RNode temp = null;

        while(curr != null) {
            temp = curr.next;

            curr.next = new RNode(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = start;

        //now fix the random pointer to correct pointer

        while(curr != null) {
            if (curr.next != null) {
                curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
            }
            curr = curr.next.next;
        }


        //separate original & copy
        RNode original = start;
        RNode copy = start.next;
        temp = copy;

        while (original != null) {
            original.next = original.next.next;

            copy.next = (copy.next != null) ? copy.next.next : copy.next;

            original = original.next;
            copy = copy.next;
        }

        return  temp;

    }
}

class RNode {
    int val;
    RNode next;
    RNode random;

    public RNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
