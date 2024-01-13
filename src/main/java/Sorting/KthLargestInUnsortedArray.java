package Sorting;

public class KthLargestInUnsortedArray {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;

        for(int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                swap(arr, pIndex, j);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return (pIndex);
    }

    private static void swap(int[] arr, int m, int n) {
        int data = arr[m];
        arr[m] = arr[n];
        arr[n] = data;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int n = arr.length-1;
        quickSort(arr, 0, n);
        System.out.println("Sorted array: ");
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        int k = n-2;
        System.out.println("3rd largest : "+arr[k]);
    }
}
