package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a list of positive numbers without duplicates and a target number, find all unique combinations
of the numbers that sum to the target. Note: You may use the same number more than once.

Ex: Given the following numbers and target…

numbers = [2,4,6,3], target = 6,
return [
    [2,2,2],
    [2,4],
    [3,3],
    [6]
]
 */
public class UniqueCombination {

    public static void main(String[] args) {

        int[] arr = {1,2,4,6,3};
        int target = 4;

        Arrays.sort(arr);

        // for (int i : arr) {
        //   System.out.println(i);
        // }

        int start = 0;
        int end = arr.length-1;

        List<List<Integer>> mainList = new ArrayList<>();

        while(start<end) {
            int sum = arr[start]+arr[end];  //8
            if(sum == target) {
                List<Integer> sublist1 = new ArrayList<>();
                sublist1.add(arr[start]);
                sublist1.add(arr[end]);
                mainList.add(sublist1);
                // System.out.println(arr[start]+"  "+arr[end]);
                break;
            } else if(sum > target) {
                end--;
            } else {
                start++;
            }
        }

        for(int i=0;i<arr.length;i++) {
            if(arr[i]<= target && target%arr[i] == 0) {
                int noOfTimes = target/arr[i];

                List<Integer> sublist = new ArrayList<>();
                while(noOfTimes != 0) {
                    sublist.add(arr[i]);
                    noOfTimes--;
                }
                mainList.add(sublist);
            }
        }

        System.out.println(mainList);
    }
}
