package Array.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practise {

    public static void main(String[] args) {
        Practise p =  new Practise();

//        int arr1[] = {2, 7, 11, 15}, target1 = 9;
//        p.twoSum(arr1, 9);

//        int arr2[] = {7, 12, 3, 1, 2, -6, 5, -8, 6}, target2 = 0;
//        p.threeSum(arr2, target2);

//        int arr3[] = {1,0,-1,0,-2,2}, target3 = 0;
//        p.fourSum(arr3, target3);

        //Given two non-empty arrays of integers, find the pair of values (one value from each array)
        // with the smallest (non-negative) difference.
//        int nums1[] = {1, 3, 15, 11, 2}, nums2[] = {23, 127, 235, 19, 8};
//        smallestDifferencePair(nums1,nums2);


        int[] nums = new int[] { 1, 1, 1, 3, 5, 5, 7 };
//        removeDuplicatesSortedArray(nums);

//        Given a sorted array, remove the duplicates from the array in-place such that each element
//        appears at most twice, and return the new length.
        removeDuplicatesSortedArrayII(nums);
    }

    private static void removeDuplicatesSortedArrayII(int[] nums) {

        int j=0;
        int n = nums.length;

        for (int i=0;i<n;i++) {
            if (i<n-2 && nums[i] == nums[i+2]) {
                continue;
            }
            nums[j] = nums[i];
            j++;
        }

        System.out.println("total elements : "+j);

        for (int k=0;k<j;k++) {
            System.out.print(nums[k]+" ");
        }

    }

    private static void removeDuplicatesSortedArray(int[] nums) {

        int j=0;
        int n = nums.length;
        for (int i=0;i<n;i++) {
            if(i < n-1 && nums[i] == nums[i+1]) {
                continue;
            }
            nums[j]=nums[i];
            j++;
        }
        System.out.println("total elements : "+j);

        for (int k=0;k<j;k++) {
            System.out.println(nums[k]);
        }
    }

    private static void smallestDifferencePair(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;

        int smallestDiff = Integer.MAX_VALUE;
        int[] smallestDiffArr = new int[2];

        while (p1 < nums1.length && p2 < nums2.length) {
            int currentDiff = Math.abs(nums1[p1] - nums2[p2]);

            if(smallestDiff < currentDiff) {
                smallestDiff = currentDiff;
                smallestDiffArr[0] = nums1[p1];
                smallestDiffArr[1] = nums1[p2];
            }
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        System.out.println(smallestDiffArr);
    }

    private void fourSum(int[] nums, int target3) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i=0;i<n;i++) {
            int k = nums[i];

            for (int j=i+1;j<n;j++) {
                int m = nums[j];
                int left = j+1;
                int right = n-1;

                while(left<=right) {
                    if(nums[i]+nums[j]+nums[left]+nums[right] == target3) {
//                    System.out.println(i+" "+left+" "+right);
                        List<Integer> sublist = new ArrayList<>();
                        sublist.add(i);
                        sublist.add(j);
                        sublist.add(left);
                        sublist.add(right);
                        list.add(sublist);
                        left++;
                        right--;
                        break;
                    } else if (k+m+nums[left]+nums[right] < target3) {
                        left++;
                    } else {
                        right--;
                    }
                }


            }
        }
        System.out.println(list);
    }

    private void threeSum(int[] arr, int target) {
        Arrays.sort(arr);
//          0, 1,2,3,4,5,6,7, 8
//        {-8,-6,1,2,3,5,6,7,12}
        List<List<Integer>> list = new ArrayList<>();

        for (int i=0;i<arr.length;i++) {
            int left=i+1;
            int right=arr.length-1;

            while(left<=right) {
                if(arr[i]+arr[left]+arr[right] == target) {
//                    System.out.println(i+" "+left+" "+right);
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(i);
                    sublist.add(left);
                    sublist.add(right);
                    list.add(sublist);
                    left++;
                    right--;
                    break;
                } else if (arr[i]+arr[left]+arr[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(list);
    }

    private void twoSum(int[] arr, int target) {

        int left = 0;
        int right = arr.length-1;

        while(left<=right) {
            if (arr[left] + arr[right] == target) {
                System.out.println(left +" "+ right);
                break;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
        }

    }
}
