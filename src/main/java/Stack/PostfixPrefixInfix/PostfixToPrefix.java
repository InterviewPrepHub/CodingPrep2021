package Stack.PostfixPrefixInfix;

import java.util.Stack;

public class PostfixToPrefix {

    public static void main(String[] args) {
        String str = "ABC/-AK/L-*";
        String res = post_to_pre(str);
        System.out.println("res : "+ res);
    }

    private static String post_to_pre(String str) {
        Stack<String> s = new Stack<>();

        for (int i=0;i<str.length();i++) {
            if (isOperator(str.charAt(i))) {    // /
                String op1 = s.peek();  //C
                s.pop();
                String op2 = s.peek();  //B
                s.pop();

                String res = str.charAt(i) + op2 + op1; //  /BC
                s.push(res);    // A, /BC
            } else {
                s.push(str.charAt(i) + ""); //A,B,C
            }
        }

        String ans = "";
        for (String s1 : s) {
            ans += s1;
        }

        return ans;
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
