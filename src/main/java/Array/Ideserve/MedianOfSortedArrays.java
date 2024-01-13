package Array.Ideserve;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Given two sorted arrays a and b each of size n, find the median of the array obtained by merging these two arrays.
 *
 * Example –
 *
 * a = 1, 3, 5, 11, 17
 * b = 9, 10, 11, 13, 14
 *
 * Sorted(a+b) = 1, 3, 5, 9, 10, 11, 11, 13, 14, 17
 *
 * Median = (10 + 11)/2
 *              = 10.5
 */
public class MedianOfSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,11,17};
        int[] arr2 = {9,10,11,13,14};


//        getMedian(arr1, arr2);

        System.out.println(getMedianOfTwoSortedArrays(arr1, arr2));

    }

    private static double getMedianOfTwoSortedArrays(int[] arr1, int[] arr2) {

        int m = arr1.length;
        int n = arr2.length;

        if (m > n) {
            return getMedianOfTwoSortedArrays(arr2, arr1);
        }

        int low = 0;
        int high = m-1;

        while(low<=high) {

            int partitionX = (low+high)/2;
            int partitionY = (m+n+1)/2 - partitionX;

            int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE : arr1[partitionX-1];
            int minRightX = (partitionX==m) ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE : arr2[partitionY-1];
            int minRightY = (partitionY==n) ? Integer.MAX_VALUE : arr2[partitionY];

            if (maxLeftX <= minRightY && minRightX >= maxLeftY) {
                if ((m + n) % 2 != 0) {
                    return (double) (Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2;
                }
                else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX-1;
            } else {
                low = partitionX+1;
            }

        }
        throw new IllegalArgumentException();
    }

    private static void getMedian(int[] arr1, int[] arr2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i: arr1) {
            minHeap.add(i);
        }

        for (int i: arr2) {
            minHeap.add(i);
        }

        int[] arr = new int[arr1.length+ arr2.length];

        int i=0;
        while (!minHeap.isEmpty()) {
            arr[i] = minHeap.poll();
            i++;
        }

        for (int i1 : arr) {
            System.out.println(i1);
        }
    }
}
