package Array.TwoPointers;

/*
Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three
different array elements as lengths of three sides of triangles.

Example 1:

Input:
n = 3
arr[] = {3, 5, 4}
Output:
1
Explanation:
A triangle is possible
with all the elements 5, 3 and 4.


Input:
n = 5
arr[] = {6, 4, 9, 7, 8}
Output:
10
Explanation:
There are 10 triangles
possible  with the given elements like
(6,4,9), (6,7,8),...
 */
import java.util.Arrays;

public class CountPossibleTriangles {

    public static void main(String[] args) {

        int[] arr = { 4, 3, 5, 7, 6 };
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;

        for (int i=n-1;i>=1;i--) {
            int l=0, r = i-1;

            while(l<r) {
                if(arr[l]+arr[r] > arr[i]) {
                    count = count + r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        System.out.println("count : "+count);
    }
}
