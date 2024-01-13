package Array.Ideserve;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int n = arr.length;

        findProduct(arr, n);

        productOfArray(arr,n);

    }

    private static void productOfArray(int[] arr, int n) {

//        1,2,3,4
//        1,1,2,6
//        24,12,4,1
//        24,12,8,6

        int[] res = new int[n];

        int left = 1;
        for (int i=0;i<n;i++) {
            if (i>0) {
                left = left * arr[i];
            }
            res[i] = left;
        }

        int right = 1;
        for (int i=n-1;i>=0;i--) {
            if (i<=n-1) {
                right = right * arr[i];
            }
            res[i] = right;
        }


    }

    private static void findProduct(int[] arr, int n) {
        int res = 1;
        for (int i = 0; i< n; i++) {
            res = res * arr[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i< n; i++) {
            ans[i] = res / arr[i];
        }

        for (int i = 0; i< n; i++) {
            System.out.println(ans[i]);
        }
    }
}
