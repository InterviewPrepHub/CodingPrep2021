package Array.Ideserve;

/**
 * Given an array of size n, find a peak element in the array.
 * For example:
 * In Array [1,4,3,6,7,5] 4 and 7 are Peak Elements. Return any one Peak Element.
 */
public class FindPeakElement {

    public static void main(String[] args) {
//        int[] arr = {1,2,3,1};
        int[] arr = {40,10,20,5,45,50,65,90,35};
        peakElement(arr);
    }

    private static void peakElement(int[] arr) {

        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = (start+end)/2;
            if (arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
                System.out.println(arr[mid]);
                break;
            }
            else if(arr[mid-1] > arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
    }
}
