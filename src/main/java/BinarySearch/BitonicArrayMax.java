package BinarySearch;

/*
Bitonic array is a sorted array where first part of array is in ascending order and second part is in decending array.
 */
public class BitonicArrayMax {

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int start = 0, end = arr.length;
        while (start< end) {
            int mid = (start+end)/2;
            if (arr[mid] > arr[mid+1]) {
                end = mid;
            }
            if (arr[mid] < arr[mid+1]) {
                start = mid+1;
            }
        }
        System.out.println(arr[start]);
    }
}
