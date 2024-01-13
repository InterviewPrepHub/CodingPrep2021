package Array.BuySellStocks;

public class BuyAndSellStocksOverKTransaction {

/*

k=2

                           day prices---->
                    0   1    2   3    4    5
                    5   11   3   50   60   90
                0.  0   0    0   0    0    0
transaction     1.  0.  6.   6.  47.  57.  87
                2.  0.  6.   6.  53.  63.  93



profit = max {
  profit[k][d-1],

  prices[d] + max(-prices[x] + profit[k-1][x])
        where 0<=x<d

}


*/

    /**
     * This is slow method but easier to understand.
     * Time complexity is O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
     */
    public static int maxProfitSlowSolution(int prices[], int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]);
                }
                T[i][j] = Math.max(T[i][j-1], maxVal);
            }
        }
//        printActualSolution(T, prices);
        return T[K][prices.length - 1];
    }


    public static void main(String[] args) {
//        int[] prices = {2, 5, 7, 1, 4, 3, 1, 3};
//        int k = 3;
        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 2;
        System.out.println(maxProfitSlowSolution(prices, k));
    }
}
