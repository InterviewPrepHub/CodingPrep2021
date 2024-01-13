package BinarySearch;

public class BinarySearchIn2DArray {

    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        int k = 29;
//        binarySearch1(arr, k);
        binarySearchIn2D(arr,k);
    }

    private static void binarySearch1(int[][] arr, int k) {
        int n = arr.length;
        int m = arr[0].length;
        int i=0, j=m-1;
        while (i<=n-1 && j>=0) {
            if (arr[i][j] == k) {
                System.out.println(i+", "+j);
                return;
            }
            else if(arr[i][j] > k) {
                j--;
            } else {
                i++;
            }
        }
    }

    private static void binarySearchIn2D(int[][] arr, int k) {
        int i=arr.length; // row
        int j=arr[0].length; // col

        int m=0 , n=j-1;

        while(m<=i-1 && n>=0) {
            if(arr[m][n] == k) {
                System.out.println(m+"--->"+n);
                return;
            }
            if(arr[m][n] > k) {
                n--;
            } else {
                m++;
            }
        }
    }
}
