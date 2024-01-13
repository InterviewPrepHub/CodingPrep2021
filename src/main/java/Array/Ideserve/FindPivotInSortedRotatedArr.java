package Array.Ideserve;

/**
 * Given a sorted integer array which is rotated any number of times, find the pivot index
 * i.e. index of the minimum element of the array.
 * Ex: In array {78, 82, 99, 10, 23, 35, 49, 51, 60}
 */
public class FindPivotInSortedRotatedArr {

    public static void main(String[] args) {
        int[] arr = {78, 82, 99, 10, 23, 35, 49, 51, 60};

        int start = 0;
        int end = arr.length-1;

        while (start<=end) {

            int mid = (end - start)/2 + start;

            if (arr[mid] > arr[mid+1]) {
                System.out.println(mid+1);
                break;
            } else if (arr[start] <= arr[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
    }
}
