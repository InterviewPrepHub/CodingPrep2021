package Array.Palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(printAllPalindromicSubstrings(str));
    }

    private static List<String> printAllPalindromicSubstrings(String str) {

        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();

        findPalindromicSubStr(str, 0, "", list);

        return list;
    }

    private static void findPalindromicSubStr(String str, int start, String current, List<String> list) {

        if (!current.isEmpty() && isPalin(current)) {
            list.add(current);
        }

        for (int i = start; i < str.length(); i++) {
            findPalindromicSubStr(str,i+1, current+str.charAt(i), list);
        }
    }

    private static boolean isPalin(String current) {

        int left = 0, right = current.length() - 1;

        while (left <= right) {
            if(current.charAt(left) != current.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
