package Array;

/*
Given an array A[] of N positive integers which can contain integers from 1 to P
where elements can be repeated or can be absent from the array. Your task is to
count the frequency of all elements from 1 to N.

keep TC - > O(n) & space complexity -> O(1)
 */

import java.util.HashMap;
import java.util.Map;

public class CountFequencyOfElements {

    public static void main(String[] args) {
        int[] arr = {2,3,2,3,5};

        frequency(arr,arr.length);

    }

    private static void frequency(int[] arr, int n) {

        //substract 1 to bring elements within range of 1 to n-1
        for (int i=0;i<n;i++) {
            arr[i] = arr[i] - 1;
        }

        //use every element arr[i] as index and add n to veery element
        //present in arr[i] % n to keep track of count of occurrences
        for (int i=0;i<n;i++) {
            arr[arr[i] % n] = arr[arr[i] % n] + n;
        }

        for(int i=0;i<n;i++) {
            System.out.println((i+1) +" ---> "+(arr[i]/n));
        }
    }
}
