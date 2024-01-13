package Array.SlidingWindow;

/**
 * Given an array A of 0's and 1's, and a value K which indicates that you may change up to K values from 0 to 1.
 * Return the length of the longest (contiguous) subarray that contains only 1’s.
 *
 * Example 1:
 *
 * Input: A = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], K = 2
 * Output: 6
 *
 * To obtain the longest contiguous subarray of 1s, you can flip the 0s at index 5 and 10 to 1s:
 * [1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1]
 * Example 2:
 *
 * Input: A = [0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the 0s at index 6, 9, and 10 with 1s to get the longest contiguous subarray of 1s.
 */

public class LongestSubarrayWithOnesAfterReplacement {

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, k = 2;

        int windowStart = 0;
        int numReplacements = 0;
        int max_len = Integer.MIN_VALUE;

        for (int windowEnd=0;windowEnd<arr.length;windowEnd++) {
            if(arr[windowEnd] == 0) {
                numReplacements++;
            }

            while(numReplacements > k) {
                if(arr[windowStart] == 0) {
                    numReplacements--;
                }
                windowStart++;
            }

            max_len = Math.max(max_len, windowEnd-windowStart+1);
        }
        System.out.println(max_len);
    }
}
