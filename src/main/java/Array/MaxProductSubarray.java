package Array;

public class MaxProductSubarray {

    public int maxProduct(int[] nums) {

        int res =Integer.MIN_VALUE;
        int curr_max = 1, curr_min = 1;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i] == 0) {
                curr_max = 1;
                curr_min = 1;
            }

            int temp = curr_max;
            curr_max = Math.max(Math.max(nums[i]*curr_max, nums[i]*curr_min), nums[i]);
            curr_min = Math.min(Math.min(nums[i]*temp, nums[i]*curr_min), nums[i]);
            res = Math.max(curr_max, res);
        }

        return res;

    }

    public static void main(String[] args) {
//        int[] a= {2,3,-2,4};
//        int[] a = {-2,0,-1};
        int[] a = {-6, 4, -5, 8, -10, 0, 8};
        MaxProductSubarray m = new MaxProductSubarray();
        System.out.println(m.maxProduct(a));
    }
}
