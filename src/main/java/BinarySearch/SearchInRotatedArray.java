package BinarySearch;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {8, 11, 13, 15, 1, 4};

        int k = 1;

        int start = 0, end = arr.length-1;


        System.out.println(findTarget(arr, k));

//        int res = searchInSemiSortedArr(arr, k);
//        System.out.println(res);

    }

    private static int findTarget(int[] arr, int target) {
        if(arr == null && arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int mid = (left+right)/2;

            if (arr[mid] == target) {
                return mid;
            }

            if(arr[left] <= arr[mid]) { //left arr is sorted
                if(target >= arr[left] && target <= arr[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {   //right arr is sorted
                if(target >= arr[mid] && target <= arr[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;
    }

    private static int searchInSemiSortedArr(int[] arr, int k) {

        int left = 0;
        int right = arr.length-1;

        while(left < right) {
            int mid = right - (left+right)/2;

            if(arr[left] < arr[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }

        }

        int start = left;
        left = 0;
        right = arr.length-1;

        if(k >= arr[start] && k <= arr[right]) {
            left = start;
        } else {
            right = start;
        }

        while(left <= right) {
            int mid = right - (left+right)/2;

            if(arr[mid] == k) {
                return mid;
            }

            if(arr[mid] > k) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;

    }


}
