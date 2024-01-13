package Array.Ideserve;

/**
 * Given a sorted integer array which is rotated any number of times and an integer num,
 * find the index of num in the array.
 * If not found, return -1.
 */

public class FindElementInSortedRotatedArr {

    public static void main(String[] args) {
        int[] arr = {78, 82, 99, 10, 23, 35, 49, 51, 60};

        int k = 49;

//        int startIndex = findPivotElement(arr, k);
//        System.out.println(startIndex);
//
//        if(arr[startIndex] < k) {
//            int mid = findElementWithPivotElement(arr,k, startIndex);
//            System.out.println(mid);
//        }

        System.out.println(findElementWithoutPivotElement(arr,k));
    }

    private static int findElementWithoutPivotElement(int[] arr, int k) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {

            int mid = (end-start)/2 + start;

            if (arr[mid] == k) {
                return mid;
            }

            if (arr[start]<=arr[mid]) {
                //start to mid is sorted
                if (arr[start] <= k && k <= arr[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                //mid to end is sorted
                if (arr[mid] <= k && k <= arr[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    private static int findElementWithPivotElement(int[] arr, int k, int startElement) {

        int start = startElement;
        int end = arr.length-1;

        while(start <= end) {

            int mid = (end-start)/2 + start;

            if(arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                start = mid+1;
            } else {
                end = mid-1;
            }

        }
        return -1;
    }

    private static int findPivotElement(int[] arr, int k) {

        int start = 0;
        int end = arr.length-1;

        while (start<=end) {
            int mid = (end-start)/2 + start;

            if(arr[mid] > arr[mid+1]) {
                return mid+1;
            } else if (arr[start] <= arr[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
