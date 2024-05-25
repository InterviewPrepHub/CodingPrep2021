package Stack.Parentheses;

import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = ")()(()()";
        int n = longestValidParentheses(s);
        System.out.println(n);
    }

    //TC - O(n)
    //SC - O(n)
    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                    end = i;
                    start = stack.peek();
                }
            }
        }

        System.out.println("start : "+start);
        System.out.println("end : "+end);
        return max;
    }
}
