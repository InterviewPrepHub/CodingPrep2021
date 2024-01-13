package Array;

public class MaxSumSubArray {

    public static void main(String[] args) {

        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};

        int curr_max = a[0];
        int max_so_far = a[0];

        for (int i=1;i<a.length;i++) {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(curr_max, max_so_far);
        }

        System.out.println(max_so_far);
    }
}
