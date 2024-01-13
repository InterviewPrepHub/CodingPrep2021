package Array;

import java.util.PriorityQueue;

public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double median = 0;

        if(nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> p = new PriorityQueue<>();

        for(int i=0; i<nums1.length;i++) {
            p.add(nums1[i]);
        }

        for(int i=0; i<nums2.length;i++) {
            p.add(nums2[i]);
        }

        int size = p.size();
        int[] arr = new int[size];
        int i=0;

        while(!p.isEmpty()) {
            arr[i] = p.poll();
            i++;
        }

        if(arr.length % 2 == 0) {
            int mid = arr.length/2;
            median = (double)(arr[mid]+arr[mid-1])/2;
        } else {
            int mid = arr.length/2;
            median = (double)arr[mid];
        }

        return median;


    }

    public static void main(String[] args) {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
        double res = m.findMedianSortedArrays(arr1,arr2);
        System.out.println(res);
    }
}
