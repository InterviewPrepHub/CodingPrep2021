package Array.Palindrome;

/*
Given a string S, Find the length of the longest palindromic subsequence.
str = LPASPAL
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String str = "LPASPAL";
        int res = lps(str.toCharArray(), 0, str.length() - 1);
        System.out.println("res : "+res);
    }

    private static int lps(char[] str, int m, int n) {
        //case1 : if there is only one character
        if (m==n) {
            return 1;
        }

        //case2 :  if there are only 2 characters & both are same
        if (str[m] == str[n] && m+1==n) {
            return 2;
        }

        //case3: if first & last character are same
        if (str[m] == str[n]) {
            return lps(str, m+1, n-1)+2;
        }

        //case3: if first & last char are not same
        return Math.max(lps(str, m, n-1), lps(str, m+1, n));

    }
}
