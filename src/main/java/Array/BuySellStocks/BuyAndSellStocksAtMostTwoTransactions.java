package Array.BuySellStocks;

public class BuyAndSellStocksAtMostTwoTransactions {

    public static void main(String[] args) {

        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 2;

        int n = prices.length;

        int[][] dp = new int[n][n];

        for (int j=0;j<dp.length;j++) {
            dp[0][j] = 0;
        }

        for (int i=0;i<dp.length;i++) {
            dp[i][0] = 0;
        }

        for (int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {

                int maxVal = 0;

                for (int m=0;m<j;m++) {
                    maxVal = Math.max(maxVal,prices[j]-prices[m]+dp[i-1][m]);
                }

                dp[i][j] = Math.max(dp[i][j-1],maxVal);
            }
        }

        System.out.println(dp[k][n-1]);

    }
}
