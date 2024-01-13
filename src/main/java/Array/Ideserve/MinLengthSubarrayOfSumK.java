package Array.Ideserve;

/**
 * Given an array A having positive and negative integers and a number k,
 * find the minimum length sub array of A with sum = k.
 */
public class MinLengthSubarrayOfSumK {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,-1,6,4,3,8};
        int k = 7;

        MinLengthSubarrayOfSumK s = new MinLengthSubarrayOfSumK();
        s.findMinLengthSubArray(arr, k);
    }

    private void findMinLengthSubArray(int[] arr, int k) {

        int n = arr.length;
        int start = 0;
        int end = 0;
        int max_len = Integer.MAX_VALUE;

        for (int i=0;i<n;i++) {
            int curr_sum = 0;
            curr_sum+=arr[i];
            for (int j=i+1;j<n;j++) {
                curr_sum+=arr[j];

                if (curr_sum == k) {
                    start = i;
                    end = j;
                    int len = end-start+1;
                    if(max_len > len) {
                        max_len = len;
                    }
                    break;
                } else if (curr_sum > k) {
                    break;
                }
            }
        }

        while (start <= end) {
            System.out.println(arr[start]);
            start++;
        }

        System.out.println(max_len);
    }
}
