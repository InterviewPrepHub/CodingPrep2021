package Array.Palindrome;

/*
Given a string S, find the longest palindromic substring of S.
 */
public class LongestPalindromicSubstring {

    static int count = 0;
    public static String lps(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();
        boolean[][] palin = new boolean[n][n];
        for (int curr_len=0;curr_len<palin.length;curr_len++) {
            for (int i=0, j=curr_len;j< palin.length;i++,j++) {

                if(curr_len == 0) {
                    palin[i][j] = true;
                }
                else if (curr_len == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        palin[i][j] = true;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && palin[i+1][j-1]) {
                        palin[i][j] = true;
                    }
                }

                if(palin[i][j]){
                    count++;
                    start = i;
                    end = j;
                }
            }
        }

        String ans = "";
        for (int i=start;i<=end;i++) {
            ans += s.charAt(i);
        }
        System.out.println(count);
        return ans;
    }

    public static void main(String[] args) {
        String str = "banana";
        String res = lps(str);
        System.out.println("res : "+res);
    }
}
