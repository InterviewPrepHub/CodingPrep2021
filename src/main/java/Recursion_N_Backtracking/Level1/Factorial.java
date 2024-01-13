package Recursion_N_Backtracking.Level1;

public class Factorial {

    public static void main(String[] args) {

        Factorial f = new Factorial();
        int n = 5;

//        int res = f.fact(n);
//        System.out.println(res);

        Node tail = new Node(1, null);
        for(int i=2;i<=n; i++) {
            f.multiply(tail,i);
        }

        f.print(tail);
    }

    private int fact(int n) {
        if(n==0) {
            return 1;
        }
        int f = fact(n-1);
        int f1 = n * f;
        return f1;
    }

    private void print(Node tail) {
        if (tail == null) return;
        print(tail.prev);
        System.out.println(tail.data);
    }

    private static void multiply(Node tail, int n) {

        Node temp = tail;
        Node prevNode = tail;
        int carry = 0;
        while(temp != null) {
            int data = temp.data * n + carry;

            temp.data = data % 10; //stores last digit
            carry = data / 10;
            prevNode = temp;
            temp = temp.prev;
        }

        while (carry!=0) {
            prevNode.prev = new Node((int) (carry % 10),null);
            carry /= 10;
            prevNode = prevNode.prev;
        }
    }
}

class Node {
    int data;
    Node prev;

    public Node(int data, Node prev) {
        this.data = data;
        this.prev = prev;
    }
}
