package Array.Ideserve;

/**
 * Given an integer array and a number k, print the maximum average subarray of size k.
 *
 * Maximum average subarray of size k is a subarray (sequence of contiguous elements in the array)
 * for which the average is maximum among all subarrays of size k in the array.
 * Average of k elements = (sum of k elements)/k
 * Since k is greater than 0, the maximum sum subarray of size k will also be maximum average subarray
 * of size k. So, the problem reduces to finding maximum sum subarray of size k in the array.
 */
public class MaxAvgSubArrOfSizeK {

    public static void main(String[] args) {
        int[] arr = {11,-8,16,-7,24,-2,3};
        int k = 3;
        int windowSum = 0;
        int windowStart = 0;
        int max_sum = Integer.MIN_VALUE;

        for (int windowEnd = 0;windowEnd< arr.length;windowEnd++) {
            windowSum += arr[windowEnd];

            if(windowEnd-windowStart+1==k) {
                windowSum = windowSum/k;
                max_sum = Math.max(max_sum, windowSum);
                windowSum=-arr[windowStart];
                windowStart++;
            }
        }

        System.out.println(max_sum);

    }


}
