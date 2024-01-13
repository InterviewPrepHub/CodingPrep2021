package Stack.Parentheses;

/**
 * 921. Minimum Add to Make Parentheses Valid
 *
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 */
public class MinAddToValidParantheses {

    public int minAdd(String str) {
        int balance = 0;
        int total = 0;

        for (int i=0;i<str.length();i++) {
            balance += getChar(str.charAt(i));
            if(balance < 0) {
                total++;
                balance=0;
            }
        }

        if (balance > 0) {
            total+=balance;
        }

        return total;

    }

    private int getChar(char charAt) {
        if (charAt == '(') {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinAddToValidParantheses m = new MinAddToValidParantheses();
        System.out.println(m.minAdd("())"));
    }
}
