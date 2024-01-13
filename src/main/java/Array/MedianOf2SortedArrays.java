package Array;

import javax.swing.*;

public class MedianOf2SortedArrays {

    public static void main(String[] args) {

        int[] a = {2, 3, 8, 13};
        int[] b = {1, 5, 9, 10, 15, 20, 0, 0, 0, 0};

        merge1(a, b);
    }

    private static void merge1(int[] a, int[] b) {
        int i=a.length-1;
        int j=b.length-1; //bigger
        int k = j-i-1;

        while(i>=0) {
            if (k>=0 && a[i] > b[k]) {
                b[j] = a[i];
                i--;
            } else {
                b[j] = b[k];
                k--;
            }
            j--;
        }

        printArray(b);

    }

    public static void printArray(int[] arr) {
        for(int i=0;i< arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public void mergeWithNoExtraSpace(int a, int b) {

    }

}
