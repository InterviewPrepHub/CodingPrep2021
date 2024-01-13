package Stack.PostfixPrefixInfix;

import java.util.Stack;

public class PrefixToPostfix {

    public static void main(String[] args) {
        String str = "*-A/BC-/AKL";
        String res = pre_to_post(str);
        System.out.println("result : "+ res);
    }

    private static String pre_to_post(String str) {
        Stack<String> s = new Stack<>();
        for(int i=str.length()-1;i>=0;i--) {
            if (isOperator(str.charAt(i))) {
                String op1 = s.peek();  //B
                s.pop();
                String op2 = s.peek();  //A
                s.pop();

                String res = op1+op2+str.charAt(i);
                s.push(res);
            } else {
                s.push(str.charAt(i)+"");   //B,A
            }
        }

        String ans = "";
        for (String a1 : s) {
            ans += a1;
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
