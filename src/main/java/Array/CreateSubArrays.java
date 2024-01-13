package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateSubArrays {

    public void createSubArrays(int[] arr) {

        int n = arr.length;

        //pick start point
        for(int i=0;i<n;i++) {

            //pick end point
            for (int j=i;j<n;j++) {

                //create subarays with start & end points
                for (int k=i;k<=j;k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
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

    public static void main(String[] args) {
        CreateSubArrays c = new CreateSubArrays();
        int[] arr = {1,2,3,4};
        c.createSubArrays(arr);
    }
}
