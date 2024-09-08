package Recursion_N_Backtracking.Level1;

import java.util.HashSet;

public class PrintPermutations {

    public static void main(String[] args) {
        String s = "abc";
        HashSet<String> set = new HashSet<>();
        generatePermuation(s, 0, s.length(), set);

        for (String str : set) {
            System.out.println(str);
        }
    }

    private static void generatePermuation(String s, int start, int end, HashSet<String> set) {

        if(start == end-1) {
            set.add(s+" ");
        } else {
            for (int i = start; i < end; i++) {
                s = swap(s, start, i);
                generatePermuation(s, start+1, end, set);
                s = swap(s, start, i);
            }
        }
    }

    private static String swap(String str, int start, int end) {
        char[] ch = str.toCharArray();
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
        return String.valueOf(ch);
    }
}
