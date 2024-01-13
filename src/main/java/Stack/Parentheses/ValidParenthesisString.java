package Stack.Parentheses;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "(*)"
 * Output: true
 * Example 3:
 *
 * Input: s = "(*))"
 * Output: true
 *
 *
 * Good solution: https://leetcode.com/problems/valid-parenthesis-string/solutions/543521/java-count-open-parenthesis-o-n-time-o-1-space-picture-explain/
 */

public class ValidParenthesisString {

    /**
     * Check string with only one type of parantheses '(' & ')'
     */

    public boolean checkValidString1(String s) {
        int openCount = 0;

        for (char c : s.toCharArray()) {
            if(c == '(') {
                openCount++;
            }
            else if (c == ')') {
                openCount--;
            }

        }

        return openCount == 0 ? true : false;
    }

    public boolean checkValidString2(String s) {
        int cmax = 0;
        int cmin = 0;

        for (char c : s.toCharArray()) {
            if(c == '(') {
                cmax++;
                cmin++;
            }
            else if (c == ')') {
                cmax--;
                cmin--;
            }
            else if(c == '*') {
                cmax++;
                cmin--;
            }

            if (cmax < 0) return false;
            cmin = Math.max(cmin,0);
        }
        return cmin == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString v = new ValidParenthesisString();
        boolean res1 = v.checkValidString1("()");
        System.out.println(res1);

        boolean res2 = v.checkValidString2("(*()");
        System.out.println(res2);
    }
}
