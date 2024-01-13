package Array;

/*
Given an array nums[] of size n, construct a Product Array P (of same size n) such
that P[i] is equal to the product of all the elements of nums except nums[i].
p[i] = {10, 3, 5, 6, 2};
p[i] = {180, 600, 360, 300, 900};
 */
public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};

        ProductArrayExceptSelf p = new ProductArrayExceptSelf();
        int[] res = p.maxSum(arr);
        for(int i=0;i< res.length;i++){
            System.out.println(res[i]);
        }

        /*int[] res = factorial(arr);
        for(int i=0;i< res.length;i++){
            System.out.println(res[i]);
        }*/
    }

    private int[] maxSum(int[] a) {

        int n = a.length;
        int[] res = new int[n];

        int left = 1;
        for(int i=0;i<n;i++) {
            if (i > 0) {
                left = left * a[i-1];
            }
            res[i] = left;
        }

        int right = 1;
        for (int i=n-1;i>=0;i--) {
            if(i < n-1) {
                right = right * a[i+1];
            }
            res[i] = res[i] * right;
        }

        return res;
    }

    private static int[] factorial(int[] arr) {
        int len = arr.length;
        int[] a = new int[len];
        for(int j=0;j<len;j++){
            int fact = 1;
            for(int i=0;i<len;i++){
                fact=fact*arr[i];
            }
            fact=fact/arr[j];
            a[j] = fact;
        }
        return a;
    }
}
