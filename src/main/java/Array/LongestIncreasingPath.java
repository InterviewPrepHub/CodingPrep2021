package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestIncreasingPath {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 3 };
//        createSubArrays(arr,2,3);
        incSubArray(arr,2,3);
    }

    /*
    1st loop -> 0 -> len
        list -> ar[i]
        2nd loop
        i+1 -> len
        condition of range

     */


    private static void incSubArray(int[] arr, int left, int right) {
        List<List<Integer>> mainList = new ArrayList<>();
        for (int i=0;i<arr.length;i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j=i;j<arr.length;j++) {
                if(arr[j] <= right) {
                    sublist.add(arr[j]);
                } else {
                    break;
                }
            }
            if (sublist.size() !=0) {
                mainList.add(sublist);
            }
        }

        System.out.println(mainList);
    }

    private static void createSubArrays(int[] arr, int left, int right) {
        Set<List<Integer>> set = new HashSet<>();
        for(int startPt=0;startPt<arr.length;startPt++) {
            for(int grps=startPt;grps<=arr.length;grps++) {
                List<Integer> sublist = new ArrayList<>();
                for (int i=startPt;i<grps;i++) {
                    if(arr[i] <= right) {
                        sublist.add(arr[i]);
                    }
//                    System.out.print(arr[i]+" ");
                }
                if (sublist.size() !=0) {
                    set.add(sublist);
                }
                System.out.println();
            }
        }

        System.out.println(set);
    }

}
