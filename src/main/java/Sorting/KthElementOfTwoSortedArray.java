package Sorting;

/*
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the k’th position of the final sorted array.


Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5

 */
public class KthElementOfTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1,5,9,10,15,20,-1,-1,-1,-1};
        int[] arr2 = {2,3,8,13};

        //  1,2,3,5,8,9,10,,13,15,20

        merge(arr1, arr2);
    }

    private static void merge(int[] a1, int[] a2) {

        //take extra space & compare elements
        //take no extraspace but either of the two array has extra space to accomodate the other array
        int m = a2.length;
        int n = a1.length-m;
        int k = a1.length;

        while (n>0 && m>0) {
            if (a1[n-1] > a2[m-1]) {
                a1[k-1] = a1[n-1];
                n--;k--;
            } else {
                a1[k-1] = a2[m-1];
                m--;k--;
            }
        }

//        rest of the elements
        while (m>0) {
            a1[k-1] = a2[m-1];
            m--;
        }

        System.out.println("the two merge sorted array");
        for (int i=0;i< a1.length;i++) {
            System.out.println(a1[i]);
        }

    }
}
