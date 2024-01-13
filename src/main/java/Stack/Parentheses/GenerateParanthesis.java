package Stack.Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * This question is asked by Facebook. Given an integer N, where N represents the number of pairs of parentheses
 * (i.e. ”(“ and ”)”) you are given, return a list containing all possible well-formed parentheses you can create.
 *
 * Ex: Given the following value of N…
 *
 * N = 3,
 * return [
 *     "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParanthesis {

    static List<String> list = new ArrayList<>();
    public void generateParanthesis(int n) {
        generateParanthesis(n,0,0,"");
    }

    private void generateParanthesis(int n, int open, int closed, String s) {

        if(open==closed && open==n) {
            list.add(s);
            return;
        } else if(open == n) {
            generateParanthesis(n, open, closed+1, s+")");
        } else if(open == closed) { //()()
            generateParanthesis(n, open+1, closed, s+"(");
        } else if(open > closed) {
            generateParanthesis(n, open+1, closed,s+"(");
            generateParanthesis(n, open, closed+1,s+")");
        }
    }

    public static void main(String[] args) {

        GenerateParanthesis g = new GenerateParanthesis();
        g.generateParanthesis(3);

        System.out.println(list);
    }
}
