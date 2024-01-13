package Array.SlidingWindow;

import java.util.Stack;

public class LongestValidParanthesis {

    public static void main(String[] args) {

//        String s = "())(())";
//        String s = "(()";
        String s = ")()())";
//        String s = "()(())";
        longestParanthesis(s);

    }

    private static void longestParanthesis(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        int max_len = Integer.MIN_VALUE;

        Stack<Character> st = new Stack<>();

        for(int i = 0; i< s.length(); i++) {

            if(st.isEmpty()) {
                left = 0;
                right = 0;
            }
            char c = s.charAt(i);
            if(c == '(') {
//                left++;
                st.push(c);
            }

            char check;
            switch (c) {
                case ')' :
                    if(st.isEmpty()) {
                        break;
                    }
                    check = st.pop();
                    if(check == '(') {
                        left++;
                        right++;
                    }
                    break;

            }

            if(left == right) {
                len = left*2;
            }

            max_len = Math.max(max_len,len);

        }

        System.out.println(max_len);
    }
}
