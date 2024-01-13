package Array.Ideserve;

/**
 * How to find an element in a sorted array using Binary Search.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,4,9,10,23,35,49,51,60};
        int k = 49;

        int low = 0;
        int high = arr.length-1;

        while(low<=high) {
            int mid = (low+high)/2;

            if (arr[mid]==k) {
                System.out.println(mid);
                break;
            } else if (arr[mid] < k) {
                low = mid;
            } else {
                high = mid;
            }
        }
    }
}
