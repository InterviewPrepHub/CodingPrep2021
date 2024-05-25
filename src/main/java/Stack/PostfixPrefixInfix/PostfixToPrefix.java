package Stack.PostfixPrefixInfix;

import java.util.Stack;

public class PostfixToPrefix {

    public static void main(String[] args) {
        String str = "ABC/-AK/L-*";
        String res = post_to_pre(str);
        System.out.println("res : "+ res);
    }

    private static String post_to_pre(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (isOperator(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push(c + operand1 + operand2);
            } else {
                stack.push(String.valueOf(c));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char x) {
        switch (x) {
            case '/' : return true;
            case '*' : return true;
            case '+' : return true;
            case '-' : return true;
        }
        return false;
    }
}
