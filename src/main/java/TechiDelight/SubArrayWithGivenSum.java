package TechiDelight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an unsorted array of integers, find a subarray that adds to a given number. If there is more than one subarray with the sum of the given number, print any of them.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
Explanation: Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Output: Sum found between indexes 0 to 3
Explanation: Sum of elements between indices
0 and 3 is 10 + 2 - 2 - 20 = -10

 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3}, sum = 3;

//        subarraySum(arr, sum);

        printAllSumSubArray(arr, sum);
    }

    private static void subarraySum(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int curr_sum = 0, start=0, end=-1;

        for (int i=0;i< arr.length;i++) {
            curr_sum = curr_sum + arr[i];   //10
            if (curr_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            if (map.containsKey(curr_sum-sum)) {
                start = map.get(curr_sum-sum) + 1;
                end = i;
                break;
            }
            map.put(curr_sum, i);//[10,0]

        }
        System.out.println(start+"----"+end);
    }


    private static void printAllSumSubArray(int[] arr, int sum) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int curr_sum = 0, start = 0, end = -1;
        for (int i=0;i< arr.length;i++) {
            curr_sum = curr_sum + arr[i];

            if (curr_sum - sum == 0){
                start = 0;
                end = i;
                insert(map, curr_sum, i);
            }

            if (map.containsKey(curr_sum-sum)) {
                List<Integer> res = map.get(curr_sum - sum);

                for (Integer r : res) {
                    System.out.println("subarr start : "+(r+1) + " end : "+i);
                }
            }
            insert(map, sum, i);
        }
    }

    private static void insert(Map<Integer, List<Integer>> map, int curr_sum, int i) {
        map.putIfAbsent(curr_sum, new ArrayList<>());
        map.get(curr_sum).add(i);
    }
}























