package BinarySearch;

/*
Given an array of integers a sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
 */
public class FirstAndLastPosition {

    public static void main(String[] args) {

        int[] arr = {1, 4, 4, 10, 10, 15, 20};

        int k = 4;
        binarySearch(arr, k);

    }

    private static void binarySearch(int[] arr, int k) {
        int start = 0, end = arr.length-1;

        while(start <= end) {
            int mid = (start+end)/2;

            if(arr[mid] == k) {
                findPosition(mid, arr);
            }

            if(arr[mid] > k) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
    }

    private static void findPosition(int pos, int[] arr) {
        System.out.println("position : "+pos);
        int s=pos;
        while(s>=0) {
            if(arr[s] == arr[s-1]) {
                s--;
            } else {
                break;
            }
        }
        System.out.println("start = "+s);

        int e=pos;
        while(e<=arr.length-1) {
            if(arr[e] == arr[e+1]) {
                e++;
            } else {
                break;
            }
        }
        System.out.println("end = "+e);
    }
}
