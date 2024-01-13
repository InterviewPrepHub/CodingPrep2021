package Array.Ideserve;

import java.util.Stack;

/**
 * Given an array of integers(positive or negative), print the next greater element of all elements in the array.
 * If there is no greater element then print null.
 * Next greater element of an array element array[i], is an integer array[j], such that
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {98, 23, 54, 12, 20, 7, 27};

        Stack<Integer> st = new Stack<>();

        for (int i=0;i<arr.length;i++) {
            if (!st.isEmpty()) {
                while(st.peek() < arr[i]) {
                    System.out.println(st.peek() + " --> "+arr[i]);
                    st.pop();
                }
            }
            st.push(arr[i]);

            if (st.peek() > arr[i]) {
                st.push(arr[i]);
            }
        }

        while(!st.isEmpty()) {
            System.out.println(st.peek()+" --> "+ null);
            st.pop();
        }
    }
}
