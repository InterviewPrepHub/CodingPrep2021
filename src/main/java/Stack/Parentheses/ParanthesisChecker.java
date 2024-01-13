package Stack.Parentheses;

import java.util.Stack;

public class ParanthesisChecker {

    public boolean checker(String str) {
        Stack<Character> s = new Stack<>();
        for (int i=0;i<str.length();i++) {
            char x = str.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                s.push(str.charAt(i));  //{
            }
            if (s.isEmpty()) {
                return false;
            }
            char check;
            switch (x) {
                case ')' :
                    check = s.pop();
                    if (check == '{' || check =='[') {
                        return false;
                    }
                    break;

                case '}' :
                    check = s.pop();
                    if (check == '(' || check =='[') {
                        return false;
                    }
                    break;

                case ']' :
                    check = s.pop();
                    if (check == '(' || check =='{') {
                        return false;
                    }
                    break;
            }
        }
        return s.isEmpty();
    }

    public String test() {
        if(1==1) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void main(String[] args) {
        ParanthesisChecker p = new ParanthesisChecker();
        System.out.println(p.checker("{[]}"));

    }
}