package Sorting;

public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; //5
        int pIndex = start; //0

        for(int j = start; j <= end - 1; j++) {     //j=0,1
            if (arr[j] < pivot) {   //{j=0,arr[0]=10} , {j=1,arr[1]=7} , {j=2,arr[2]=8} , {j=3,arr[3]=9}, {j=4,arr[4]=1}
                swap(arr, pIndex, j);   //{10,7,8,9,5,1}
                pIndex++;   //1
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


    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
