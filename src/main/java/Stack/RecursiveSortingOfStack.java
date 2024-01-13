package Stack;

import java.util.Stack;

public class RecursiveSortingOfStack {

    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {
        s.push(10);
        s.push(13);
        s.push(5);
        s.push(25);
        s.push(1);
        System.out.println("unsorted stack : "+s);

        sort();
        prinStack(s);

        System.out.println();
        System.out.println("sorted stack : "+s);
    }

    private static void prinStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static void sort() {
        if (!s.isEmpty()) {
            int temp = s.peek();
            s.pop();
            sort();
            sortedInsert(temp);
        }
    }

    private static void sortedInsert(int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
        }
        int a = s.peek();
        s.pop();
        sortedInsert(x);
        s.push(a);
    }
}
