package Array;

/*
Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps,
where D is a positive integer.
 */

public class RotateArrayKTimes {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] A, int low, int high) {
        for(int i=low, j=high; i<j; i++, j--) {
            swap(A, i, j);
        }
    }

    public static void rotateArr(int[] arr, int k, int n) {

        if (k < 0 || k > arr.length ) {
            return;
        }

        //reverse second half of arr
        reverse(arr, n-k, n-1);

        //reverse first half of arr till k
        reverse(arr,0,n-k-1);

        //reverse the whole array
        reverse(arr, 0, n-1);

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArr(arr,k,arr.length);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
