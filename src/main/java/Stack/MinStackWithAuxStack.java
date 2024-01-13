package Stack;

import java.util.Stack;

public class MinStackWithAuxStack {

    Stack<Integer> s = new Stack<>(); //main stack to store elements
    Stack<Integer> aux = new Stack<>(); //special stack to store elements

    public void push(int x) {

        //push element in main stack
        s.push(x);

        //if aux stack is empty then push element in aux stack
        if (aux.empty()) {
            aux.push(x);
        }
        else {
            //push the element into aux stack only if its lesser than the top element
            if (aux.peek() >= x) {
                aux.push(x);
            }
        }

    }

    public int pop() {

        //remove top element from main stack
        int top = s.pop();

        //remove top element from aux stack only if its min
        if (top == aux.peek()) {
            aux.pop();
        }

        return top;
    }

    public int peek() {
        return s.peek();
    }

    public boolean isEmpty() {
        return s.empty();
    }

    public int getMin() {
        if (aux.isEmpty()) {
            return -1;
        }
        return aux.peek();
    }

    public static void main(String[] args) {

        MinStackWithAuxStack m = new MinStackWithAuxStack();
        m.push(10);
        m.push(22);
        m.push(12);
        m.push(6);
        m.push(54);
        System.out.println(m.getMin());

    }
}
