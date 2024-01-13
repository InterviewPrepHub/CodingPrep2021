package Recursion_N_Backtracking.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumber {

    public static void main(String[] args) {
        GenerateBinaryNumber g = new GenerateBinaryNumber();
//        g.bNum(7);
        g.bNum1(7);
    }

    private void bNum1(int n) {

        Queue<String> q = new LinkedList<>();

        q.add("p");

        while (n>0) {
            String s1 = q.peek();
            System.out.println(s1);
            n--;
            q.remove();
            String s2 = s1;

            q.add(s2+"p");
            q.add(s2+"e");
        }

    }

    private void bNum(int n) {

        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        while(n > 0) {
            n--;
            String s1 = queue.peek();
            System.out.println(s1);

            queue.remove();
            String s2 = s1;

            queue.add(s2+"0");
            queue.add(s2+"1");

        }
    }

}
