package Array.Palindrome;

import java.util.*;

public class PalindromicPermutation {

    /*
    for palindrome

    //not more than 1 character whose count is 1
    //and all the other characters should have a even count
     */


    public static boolean canPermutatePalindrome(String s) {
        int[] map = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch - 'a']++;
        }


        int single = 0, triple = 0;
        for (int i=0;i<128;i++) {
            if(map[i] == 1) {
                single++;
            }
            if(map[i] % 2 != 0) {
                triple++;
            }
            if(single > 1 || triple > 1) {
                return false;
            }
        }
        return true;
    }



    //=====================================================================================

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String s= "aabb";
//        String s="malayalam";

        System.out.println(canPermutatePalindrome(s));

        /*printPermutation(s, "");

        Set<String> set = new HashSet<>();

        for (String str : list) {
            if(isPalin(str)) {
                set.add(str);
            }
        }

        for (String s1 : set) {
            System.out.println(s1);
        }*/

    }

    private static boolean isPalin(String prefix) {

        int i = 0, j = prefix.length()-1;

        while (i<=j) {
            if (prefix.charAt(i) != prefix.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static void printPermutation(String s, String psf) {

        if (s.isEmpty()) {
            list.add(psf);
//            System.out.println(psf);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ros = s.substring(0,i) + s.substring(i+1);
            printPermutation(ros, psf+ch);
        }
    }
}


