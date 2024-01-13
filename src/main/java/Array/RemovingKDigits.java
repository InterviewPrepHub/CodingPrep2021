package Array;

import java.util.Stack;

/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

 */
public class RemovingKDigits {

    public static void main(String[] args) {

        String num = "1432213";
        int k = 3;
        Stack<Character> s = new Stack<Character>();

        if (num == null || k == 0) {
            System.out.println(num);
        } ;

        if (num.length() == k) {
            System.out.println("0");
        }

        // if more significant digit is greater than less significant digit remove it

        int index = 0;
        Stack<Character> stack = new Stack<>();

        while (index < num.length()) {
            char ch = num.charAt(index);
            int res = Integer.parseInt(String.valueOf(ch));
            // remove
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            // push
            stack.push(ch);
            index++;
        }

        // if k remaining
        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // make answer
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // reverse
        sb.reverse();


        // remove leading zeros
        while(sb.length() > 1 && sb.charAt(0) == '0' ) {
            sb.deleteCharAt(0);
        }

        System.out.println(sb.toString());

    }
}
