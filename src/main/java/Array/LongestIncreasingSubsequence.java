package Array;

import java.util.Arrays;

/*
Given an array of integers, find the longest increasing subsequence in O(nlogn) time

Example:- {3,1,5,2,6,4,9}
 */
public class LongestIncreasingSubsequence {

    //longest increasing subsequence using longest common subsequence
    public static void main(String[] args) {
//                    0, 1,  2, 3,  4,  5
        int[] arr = {12, 34, 1, 5, 40, 80};
//                    1,  2,  1, 2, 3,  4
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = 1;
        for (int i=1;i<n;i++) {
            int max_len = 0;
            for (int j=0;j<i;j++) {
                if (arr[j] < arr[i]) {
                    max_len = Math.max(max_len, dp[j]);
                }
            }
            dp[i] = max_len + 1;
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);

    }
}
