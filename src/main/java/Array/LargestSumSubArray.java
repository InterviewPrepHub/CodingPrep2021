package Array;

public class LargestSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int res = maxSumSubArray(arr);
        System.out.println(res);
        maxSumSubarrayWithIndex(arr);
    }

    private static void maxSumSubarrayWithIndex(int[] arr) {
        int curr_max = 0, global_max = 0, start = 0, end = 0, beg = 0;

        for (int i=0;i<arr.length;i++) {
            if (curr_max < 0) {
                curr_max = arr[i];
                beg = i;
            } else {
                curr_max = curr_max + arr[i];
            }

            if (global_max < curr_max) {
                global_max = curr_max;
                start = beg;
                end = i;
            }
        }

        System.out.println(start+"  "+end);
        System.out.println(global_max);
    }

    private static int maxSumSubArray(int[] arr) {
        int max_so_far = arr[0];
        int curr_max = arr[0];

        for (int i=0;i<arr.length;i++) {
            curr_max = Math.max(arr[i], curr_max+arr[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }


}
