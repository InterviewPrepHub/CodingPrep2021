package Stack;

import java.util.Stack;

public class RecursiveReverseStack {

    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        reverse();
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static void reverse() {
        if (s.isEmpty()) {
            int temp = s.peek();
            s.pop();
            reverse();

            insert_at_bottom(temp);
        }
    }

    private static void insert_at_bottom(int x) {
        if (s.isEmpty()) {
            s.push(x);
        } else {
            int a = s.peek();
            s.pop();
            insert_at_bottom(x);
            s.push(a);
        }
    }
}
