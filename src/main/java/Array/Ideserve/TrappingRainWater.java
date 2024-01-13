package Array.Ideserve;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};

        int res = findTrappedWaterArea(input);
        System.out.println(res);
    }

    private static int findTrappedWaterArea(int[] input) {

        int l = 0;
        int r = input.length-1;

        int maxLeft = input[l];
        int maxRight = input[r];

        int res = 0;

        while(l<r) {
            if (maxLeft <= maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, input[l]);
                res += maxLeft - input[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, input[r]);
                res += maxRight - input[r];
            }
        }
        return res;
    }
}
