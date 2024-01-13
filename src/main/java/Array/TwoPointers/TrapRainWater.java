package Array.TwoPointers;

/*
Good explaination - https://www.youtube.com/watch?v=ZI2z5pq0TqA
 */
public class TrapRainWater {

    public static void main(String[] args) {

        int[] ht = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] ht = {1,8,6,2,5,4,8,3,7};
        int res = trapRainWater(ht);
        System.out.println(res);
    }

    private static int trapRainWater(int[] ht) {
        int l = 0;
        int r = ht.length-1;
        int max_left = ht[l];
        int max_right = ht[r];
        int res = 0;

        while (l<r) {
            if (max_left <= max_right) {
                l++;
                max_left = Math.max(max_left, ht[l]);
                res += max_left - ht[l];
            } else {
                r--;
                max_right = Math.max(max_right, ht[r]);
                res += max_right - ht[r];
            }
        }

        return res;
    }
}
