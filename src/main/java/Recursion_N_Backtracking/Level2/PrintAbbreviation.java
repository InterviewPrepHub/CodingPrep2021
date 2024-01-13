package Recursion_N_Backtracking.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAbbreviation {

    public static void main(String[] args) {

        PrintAbbreviation p = new PrintAbbreviation();
        int n = 7;
        p.printAbb(n);
    }

    private static void printAbb(int n) {

        Queue<String> q = new LinkedList<>();
        q.add("P");
        while (n > 0) {
            n--;
            String s =  q.peek();
            System.out.println(s);
            q.remove();
            String s2 = s;

            q.add(s2+"P");
            q.add(s2+"E");
        }
    }
}
