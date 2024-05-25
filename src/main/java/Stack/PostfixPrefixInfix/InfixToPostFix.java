package Stack.PostfixPrefixInfix;

import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) {
        String infix = "((A-(B/C))*((A/K)-L))";
        String postfix = in_to_post(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }

    private static String in_to_post(String str) {

        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if(c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); //pop '('
            } else {
                //operators encountered
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    if (stack.peek() == '(') break;
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }

        }

        while(!stack.isEmpty()) {
            if (stack.peek() == '(') break;
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char c) {

        switch (c) {
            case '/' : return 2;
            case '*' : return 2;
            case '+' : return 1;
            case '-' : return 1;
        }
        return -1;
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
