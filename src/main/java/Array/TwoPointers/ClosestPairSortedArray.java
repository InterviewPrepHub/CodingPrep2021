package Array.TwoPointers;

public class ClosestPairSortedArray {

    public static void main(String[] args) {
        int[] ar1 = {1, 4, 5, 7};
        int[] ar2 = {10, 20, 30, 40};
        int m = ar1.length;
        int n = ar2.length;
        int x = 32;
        closestPair(ar1, ar2, m,n,x);
    }

    private static void closestPair(int[] ar1, int[] ar2, int m, int n, int sum) {
        int diff = Integer.MAX_VALUE;
        int l = 0, r = ar2.length-1;
        int p1=0, p2=0;

        while(l<m && r>=0) {  //{l=0} {r=3}
            if (Math.abs(ar1[l] + ar2[r] - sum) < diff) {
                p1=l;
                p2=r;
                diff = Math.abs(ar1[l]+ar2[r]-sum);
            }
            if (ar1[l] + ar2[r] > sum) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println(ar1[p1] +" "+ar2[p2]);
    }
}
