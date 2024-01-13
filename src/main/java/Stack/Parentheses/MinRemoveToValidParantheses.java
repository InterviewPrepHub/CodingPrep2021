package Stack.Parentheses;

import java.util.HashSet;
import java.util.Stack;

public class MinRemoveToValidParantheses {

    public static void main(String[] args) {
        MinRemoveToValidParantheses m = new MinRemoveToValidParantheses();
        System.out.println(m.minRemoveToMakeValid("a)b(c)d"));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(Character.isAlphabetic(c)) {
                continue;
            }
            else if(c == '(') {
                st.push(i);
            }
            else if(!st.isEmpty() && s.charAt(st.peek()) == '(' && c == ')') {
                st.pop();
            } else {
                st.push(i);
            }

        }

        HashSet<Integer> set = new HashSet<>();
        while(!st.isEmpty()) {
            set.add(st.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }
}
