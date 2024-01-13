package Sorting;

/*
Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.


Example 1:

Input:
N = 9
A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array A[1] < A[7] satisfying the required condition(A[i] < A[j]) thus giving
the maximum difference of j - i which is 6(7-1).
 */
public class MaximumIndex {

    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        maxIndex(arr);

    }

    private static void maxIndex(int[] arr) {
        for (int i=0;i< arr.length;i++) {

        }
    }
}
