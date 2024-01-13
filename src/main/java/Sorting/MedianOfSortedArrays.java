package Sorting;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1,3,4,5};
        int[] arr2 = {2,4,6,8};

        int m = arr1.length, n = arr2.length;
        int[] arr3 = new int[m+n];
        int x = m-1, y = n-1;

        int i=arr3.length-1;
        while(i>=0 & y>=0 & x>=0) {
            if(arr1[x] == arr2[y]) {
                arr3[i] = arr1[x];
                x--;i--;
                arr3[i] = arr2[y];
                y--;i--;
            }
            if(arr1[x] > arr2[y]) {
                arr3[i] = arr1[x];
                x--; i--;
            } else {
                arr3[i] = arr2[y];
                y--; i--;
            }
        }

        while(x>=0) {
            arr3[i] = arr1[x];
            x--;
            i--;
        }

        while(y>=0) {
            arr3[i] = arr2[y];
            y--;
            i--;
        }

        for(int j=0;j<arr3.length;j++) {
            System.out.println(arr3[j]);
        }

        if (arr3.length % 2 != 0) {
            int res = arr3.length-1/2;
            System.out.println(arr3[res]);
        } else {
            int start = 0;
            int end = arr3.length-1;
            int res = (start+end)/2;
            System.out.println(arr3[res]);
        }
    }
}
