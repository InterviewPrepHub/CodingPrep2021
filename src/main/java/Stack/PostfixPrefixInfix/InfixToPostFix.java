package Stack.PostfixPrefixInfix;

import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) {
        String str = "A+B";
        String res = in_to_pre(str);
        System.out.println(res);
    }

    private static String in_to_pre(String str) {

        return "";
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
