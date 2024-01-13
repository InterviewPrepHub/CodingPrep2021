package BinarySearch;

public class BinarySearchIn1DArray {

    public static void main(String[] args) {
        int[] arr = {30, 50, 80, 100, 120};
        int k = 100;
        binarySearch(arr, k);
    }

    private static void binarySearch(int[] arr, int k) {
        int n = arr.length-1;
        int start = 0, end = n ;

        while (start<=end) {
            int mid = (end-start)/2+start;
            if (arr[mid] == k) {
                System.out.println(mid);
            }
            if (arr[mid] > k) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
    }
}
