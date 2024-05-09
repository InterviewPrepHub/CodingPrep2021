package Array.Palindrome;

/*
Given a string s and an integer k, find out if the given string is a K-Palindrome or not. 
A string is K-Palindrome if it can be transformed into a palindrome by removing at most k characters from

Example(s):

Copy
Input: s = "abcdeca", k = 2
Output: true
Explanation: If removing 2 characters, 'b' and 'e' , it can be palindrome. "acdca"

 */
public class RemoveKCharForPalindrome {

    public static void main(String[] args) {

        String s = "abcdeca";

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <=n ; len++) {

            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;

                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2+dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
            
        }

        System.out.println(dp[0][n-1]);
    }
}
