package Stack;

import java.util.Stack;

public class MinStackWithoutAuxStack {

    //main stack to store the elements
    Stack<Integer> s = new Stack<>();

    //variable to store minimum elements
    int min;

    public int getMin() {
        return min;
    }

    public void push(int x) {

        if (s.isEmpty()) {
            min = x;
            s.push(x);
        }
        if (x > min) {
            s.push(x);
        } else {    //here we have encountererd a new min vale since x < min
            s.push(2*x- min);   //here instead of directly pushing the x value we push an adjusted value
            min = x;
        }
        //By pushing 2*x - min, we are effectively encoding the information necessary to retrieve the previous
        // minimum value when x is popped from the stack. This way, the logic ensures that the minimum value is
        // always updated correctly and can be retrieved without using an auxiliary stack.

    }

    public void pop() {
        if (s.isEmpty()) {
            System.out.println("Stack underflow");
        }

        int top = s.peek();
        if (top < min) {
            min = 2*top - top;
        } else {
            s.pop();
        }
    }

    public static void main(String[] args) {
        MinStackWithoutAuxStack m = new MinStackWithoutAuxStack();
        m.push(10);
        m.push(31);
        m.push(4);
        m.pop();
        System.out.println(m.getMin());
        m.push(6);
        m.push(18);

    }
}
