package Array;

import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
//        int[] arr = {1,2,4};
//        int[] arr = {3,-3,6,3};
//        int[] arr = {3,4,-1,1};
//        int[] arr = {1,2,0};
//        int[] arr = {9,6,4,2,3,5,7,0,1};
        int[] arr = {3,4,7,1};
//        Arrays.sort(arr);

        FirstMissingPositive f = new FirstMissingPositive();
        int n = f.firstMissingPositive(arr);
        System.out.println(n);
    }

    //0,1,2,3
    //3,4,7,1
    //1,2,3,4

    public int firstMissingPositive(int[] arr) {

        int n = arr.length;
        for (int i=0;i< arr.length;i++) {   //0,1

            int correctPos = arr[i] -1;
            while(arr[i] >= 1 && arr[i] <= n && arr[i] != arr[correctPos]) {    //3
                swap(i,correctPos,arr); //[7,4,3,1] , [7,1,3,4], [1,7,3,4]
                correctPos = arr[i]-1;  //6
            }
        }

        for (int i=0;i< arr.length;i++) {
            if(i+1 != arr[i]) {
                return i+1;
            }
        }
        return n+1;

    }

    public void swap(int m, int n, int[] arr) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
