package Array.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of integers, return the indices of the two numbers whose sum is equal to a given target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9.

The output should be [0, 1].
Because nums[0] + nums[1] = 2 + 7 = 9.
 */
public class TwoSum {

    public static void findTwoSum(int[] arr, int x) {
        List<List<Integer>> mainList = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int l = 0;
        int r = n-1;
        while (l<r) {
            if (arr[l]+arr[r] == x) {
                List<Integer> subList = new ArrayList<>();
//                System.out.println("l: "+l+" r: "+r);
                subList.add(arr[l]);
                subList.add(arr[r]);
                mainList.add(subList);
                l++;
                r--;
            }
            if (arr[l]+arr[r] > x) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println(mainList);
    }

    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] res = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }

        }
        return res;

    }

    public static void main(String[] args) {
//        int[] arr = {2, 7, 11, 15};
//        int x = 9;
        int[] arr = {3,2,4};
        int x = 6;
        findTwoSum(arr, x);
    }
}
