package Array.TwoPointers;

/*
Given an array of unsorted integers a and a target, find a triplet in the array whose sum is closest to the target value.
Return the sum of the triplet.

Example 1:

Input: a[] = [-2, -4, 6, 3, 7], target = 2
Output: 1
Explanation: Triplet with sum closest to target is [-2, -4, 7], sum of the triplets = 1
Example 2:

Input: a[] = [10, 2, 30, 49, 8], target = 50
Output: 48
Explanation: Triplet with sum closest to target is [10, 30, 8], sum of the triplets = 48

 */

import java.util.Arrays;

public class TripletSumClosestToTarget {

    public static int sumClosestToTarget(int[] arr, int x) {
        Arrays.sort(arr);
        int n = arr.length;
        int diff = 0;
        int closest_sum = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int l = i+1;
            int r = n-1;
            while (l<r) {
                diff = arr[i]+arr[l]+arr[r];
                if(Math.abs(x-diff) < Math.abs(closest_sum-diff)) {
                    closest_sum = diff;
                }

                if(diff > x) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return closest_sum;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        int res = sumClosestToTarget(arr, 1);
        System.out.println(res);
    }
}
