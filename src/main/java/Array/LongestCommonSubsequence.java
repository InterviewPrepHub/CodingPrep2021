package Array;

/*
Given two strings S1 and S2. Find the longest common subsequence between S1 and S2.

Example:-

S1 = "ACBEA"
S2 = "ADCA"

LCS = "ACA"
 */
public class LongestCommonSubsequence {

    //to find the length of Longest Common Subsequence
    public static int lcs(char[] s1, char[] s2, int m, int n) {

        if (m==0 || n==0) {
            return 0;
        }

        if (s1[m-1] == s2[n-1]) {
            return 1 + lcs(s1, s2, m-1, n-1);
        } else {
            return Math.max(lcs(s1, s2, m-1, n), lcs(s1, s2, m, n-1));
        }

    }


    public static void main(String[] args) {

        String s1 = "ACBEA";
        String s2 = "ADCA";

        int s1_len = s1.length();
        int s2_len = s2.length();

        int res = lcs(s1.toCharArray(), s2.toCharArray(), s1_len, s2_len);

        System.out.println("res : "+res);
    }
}
