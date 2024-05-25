package Stack.PostfixPrefixInfix;

import java.util.Stack;

public class PostfixToInfix {

    public static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (isOperator(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push("(" + operand1 + c + operand2 + ")");
            } else {
                stack.push(String.valueOf(c));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        String postfix = "ABC/-AK/L-*";
//        String postfix = "AB/";
        String infix = postfixToInfix(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + infix);
    }
}
