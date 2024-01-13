package Array;

import java.util.Map;

/*
Given a binary array arr of size N and an integer M. Find the maximum number
of consecutive 1's produced by flipping at most M 0's

Input:
N = 3
arr[] = {1, 0, 1}
M = 1
Output:
3
Explanation:
Maximum subarray is of size 3
which can be made subarray of all 1 after
flipping two zeros to 1.
 */
public class MaxNumberOf1s {

    /*
           s
        1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                                e

        e   s   zeroCount   maxConsecutive1s
        0   0   0           1
        1   0   1           2
        2   0   2           3
        3   0   2           4
        4   0   2           5
        5   1   2           5
        6   1   2           6
        7   2   2           6
        8   2   2           7
        9   2   2           8
        10  2   2           9
     */

    public static int maxConsecutives1s(int[] arr, int k) {
        int maxConsecutive1s = 0;
        int zeroCount = 0;
        int start = 0;
//        1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0) {
                zeroCount++;
            }

            while(zeroCount > k) {
                if (arr[start] == 0) {
                    zeroCount --;
                }
                start++;
            }

            maxConsecutive1s = Math.max(maxConsecutive1s, end-start+1);
        }

        return maxConsecutive1s;
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int m = 2;
        int n = args.length;
        System.out.println(maxConsecutives1s(arr, 2));

    }
}
