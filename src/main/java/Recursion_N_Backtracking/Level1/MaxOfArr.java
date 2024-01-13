package Recursion_N_Backtracking.Level1;

public class MaxOfArr {

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int[] arr = {10,20,13,25,40,23};
        int len = arr.length-1;
        int res = findMax(max, arr, 0, len);
        System.out.println(res);
    }

    private static int findMax(int max, int[] arr, int n, int len) {
        if(n>len) {
            return max;
        }
        if(arr[n] > max) {
            max = arr[n];
        }
        return findMax(max, arr, n+1, len);
    }
}
