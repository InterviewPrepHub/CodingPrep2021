package String;

/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 */

public class PalindromicSubstring {

    public static void main(String[] args) {
        PalindromicSubstring p = new PalindromicSubstring();
        int res = p.countSubstring("aaa");
        System.out.println(res);
    }

    public int countSubstring(String s) {
        int count = 0;
        int n = s.length();
        boolean[][] palin = new boolean[n][n];
        for (int curr_len=0;curr_len<palin.length;curr_len++) {
            for (int i=0, j=curr_len;j< palin.length;i++,j++) {

                if(curr_len == 0) {
                    palin[i][j] = true;
                    count++;
                }
                else if (curr_len == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        palin[i][j] = true;
                        count++;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && palin[i+1][j-1]) {
                        palin[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
