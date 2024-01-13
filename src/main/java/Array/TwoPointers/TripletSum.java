package Array.TwoPointers;

import java.util.*;

/*
Given an array of integers, find all triplets in the array that sum up to a given target value.

In other words, given an array arr and a target value target, return all triplets a, b, c such that a + b + c = target.

Example:

Input array: [7, 12, 3, 1, 2, -6, 5, -8, 6]
Target sum: 0

Output: [[2, -8, 6], [3, 5, -8], [1, -6, 5]]
 */
public class TripletSum {

    public static void main(String[] args) {

        TripletSum t = new TripletSum();
//        int[] arr = {-1,0,1,2,-1,-4};
        int[] arr = {0,0,0};

        List<List<Integer>> list = t.threeSum1(arr);
        System.out.println(list);
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ll = new LinkedList();

        for(int i=0; i<nums.length-2; i++)
        {
            if(i==0 || (i>0 && nums[i] != nums[i-1]))
            {
                int low=i+1;
                int high = nums.length-1;
                int sum = 0-nums[i];

                while(low<high)
                {
                    if(nums[low]+nums[high]==sum)
                    {
                        ll.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low<high && nums[low]==nums[low+1]) low++; // to deal with duplicates
                        while(low<high && nums[high]==nums[high-1])high--;
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high] > sum)
                    {
                        high--;
                    }
                    else
                    {
                        low++;
                    }
                }
            }
        }
        return ll;
    }

}
