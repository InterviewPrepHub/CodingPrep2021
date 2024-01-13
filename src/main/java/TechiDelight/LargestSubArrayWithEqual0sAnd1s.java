package TechiDelight;

import java.util.HashMap;
import java.util.Map;

/*
Given a binary array containing 0’s and 1’s, find the largest subarray with equal numbers of 0’s and 1’s.

For example,

Input:  { 0, 0, 1, 0, 1, 0, 0 }

Output: Largest subarray is { 0, 1, 0, 1 } or { 1, 0, 1, 0 }

i            0,  1, 2,  3, 4,  5,  6
arr          0,  0, 1,  0, 1,  0,  0
new_arr     -1, -1, 1, -1, 1, -1, -1
sum      0  -1, -2, -1,
freq         1   1   2
 */
public class LargestSubArrayWithEqual0sAnd1s {

    public static void largestSubArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();    //<sum, endIndex>

        int sum = 0, endIndex = -1, len = 0;
        map.put(0,-1);

        for (int i=0;i<arr.length;i++) {    //0, 1, 2
            int res = (arr[i] == 0) ? -1 : 1;
            sum = sum + res;    //-1, -2, -1

            if (map.containsKey(sum)) {
                if (len < i-map.get(sum)) {
                    len = i - map.get(sum);
                    endIndex = i; //2
                }
            } else {
                map.put(sum, i);    //[-1, 0], [-2,1]
            }
        }

        System.out.println("[" + (endIndex - len + 1) + ", " + endIndex + "]");

    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 0, 1, 0, 0 };
        largestSubArray(nums);
    }
}
