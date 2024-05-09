package Array.Palindrome;

/*

https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

1312. Minimum Insertion Steps to Make a String Palindrome

Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 */
public class MinInsertionsToMakeStringPalindrome {

    public static void main(String[] args) {
        String s = "mbadm";
        minInsertions(s);
    }

    //similar to lowest common subsequence
    private static void minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if(s.charAt(i-1) == s.charAt(n-j)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(n - dp[n][n]);
    }
}
