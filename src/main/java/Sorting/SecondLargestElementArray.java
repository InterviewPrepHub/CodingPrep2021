package Sorting;

public class SecondLargestElementArray {

    public static void main(String[] args) {
        int[] arr = { 12, 35, 1, 10, 34, 1 };
//        secondLargest(arr, arr.length);
        largest(arr, arr.length);
    }

    private static void largest(int[] arr, int n) {
        int first = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if (arr[i]>first) {
                first = arr[i];
            }
        }
        System.out.println("largest : "+ first);
    }

    private static void secondLargest(int[] arr, int n) {

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        if (n<2) {
            return;
        }

        for (int i=0;i<n;i++) {
            if (arr[i]>first) {
                second = first;
                first = arr[i];
            }

            else if (arr[i] > second & arr[i] != first) {
                second = arr[i];
            }

        }
        if (second == Integer.MIN_VALUE) {
            System.out.println("there is no second largest number");
        } else {
            System.out.println("second largest : "+ second);
        }
    }
}
