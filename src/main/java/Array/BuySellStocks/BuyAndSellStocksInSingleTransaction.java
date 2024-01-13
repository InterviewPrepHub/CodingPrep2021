package Array.BuySellStocks;

/*
Given an array of stock prices, find the maximum profit that can be earned by doing a single
transaction of buy and sell in the given period of time.

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

public class BuyAndSellStocksInSingleTransaction {

    public static void main(String[] args) {
//        int[] arr = {100, 80, 120, 130, 70, 60, 100, 125};
        int[] arr = {9,11,6,7,19,4,1,6,18,4};
        System.out.println(buyAndSellStocks(arr));
    }

    private static int buyAndSellStocks(int[] arr) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i=0;i<arr.length;i++) {    //100, 80, 120, 130, 70, 60, 100, 125
            minPrice = Math.min(arr[i], minPrice);  //100, 80, 80, 80, 70, 60, 60, 60
            profit = Math.max(profit, arr[i]-minPrice); // 0, 0, 40, 50, 50, 50, 40, 65
        }
        return profit;
    }
}
