package Array.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/*
Given an array of positive integers, and a positive number k, find the maximum sum of any contiguous subarray of size k.

Example 1

Input: [3, 5, 2, 1, 7], k=2
Output: 8
Explanation: Subarray with maximum sum is [1, 7].
Example 2

Input: a[] = {4, 2, 3, 5, 1, 2}, k = 3
Output: 10
Explanation: Subarray with maximum sum is [2, 3, 5]
 */
public class MaxSumSubarrayKSize {

    public static void main(String[] args) {
        int[] arr = {9, 7, 2, 4, 6, 8, 2, 1, 5};
        int k = 3;

        maxSumSubArray(arr,k);

    }
    private static void maxSumSubArray(int[] arr, int k) {
        int max_sum = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowSum = 0;

        for (int windowEnd=0;windowEnd<arr.length;windowEnd++) {

            windowSum += arr[windowEnd];

            if (windowEnd - windowStart + 1 == k) {
                max_sum = Math.max(max_sum, windowSum);
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }
        System.out.println(max_sum);
    }
}
