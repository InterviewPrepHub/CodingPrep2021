package Array.Palindrome;

public class MinCutsForPalindromicPartition {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        String s1 = "abccbc";
        min = minCuts(s1);

        /*String s = "abcbm";
        int count = 0;
        minCuts1(s,"", count);*/
        System.out.println(min);
    }

    //time complexity is n3
    private static int minCuts(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int len = 0; len < n; len++) {
            for (int i = 0, j=len; j < n ; i++,j++) {
                if(len == 0) {
                    dp[i][j] = true;
                } else if(len == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) & dp[i+1][j-1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        int[] T = new int[n];
        T[0] = 0;

        for (int i = 1; i < n; i++) {
            if(dp[0][i]) {
                T[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;

                for (int j = i; j >= 1; j--) {
                    if(dp[j][i]) {
                        if(T[j-1] < min) {
                            min = T[j-1];
                        }
                    }
                }
                T[i] = min + 1;
            }
        }
        return T[n-1];

        /*int[][] T = new int[n][n];

        for (int len = 0; len < n; len++) {
            for (int i = 0, j=len; j < n ; i++,j++) {
                if(len == 0) {
                    T[i][j] = 0;
                } else if(len == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        T[i][j] = 0;
                    } else {
                        T[i][j] = 1;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) & dp[i+1][j-1]) {
                        T[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j ; k++) {
                            int left = T[i][k];
                            int right = T[k+1][j];

                            if(left+right+1 < min) {
                                min = left + right + 1;
                            }
                        }
                        T[i][j] = min;
                    }
                }
            }
        }
        return T[0][n-1];*/
    }

    private static void minCuts1(String s, String asf, int count) {

        if(s.isEmpty()) {
            System.out.println(asf);
            min = Math.min(min, count);
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            String prefix = s.substring(0,i+1);
            String ros = s.substring(i+1);

            if(isPalin(prefix)) {
                minCuts1(ros, asf+"("+prefix+")", count+1);
            }
        }
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
}
