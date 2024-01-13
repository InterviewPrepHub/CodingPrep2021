package Array.BuySellStocks;

/*
Given an array of stock prices, find the maximum profit that can be earned by performing
multiple non-overlapping transactions (buy and sell)

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

 */
public class BuyAndSellStocksOverMultipleTransaction {

    public static void main(String[] args) {
        int[] arr = {100, 80, 120, 130, 70, 60, 100, 125};
        System.out.println(buyAndSellStocks(arr));
    }

    private static int buyAndSellStocks(int[] arr) {
        int profit = 0;
        for (int i=1;i<arr.length;i++) { // 80, 120, 130, 70, 60, 100, 125
            int currentProfit = arr[i] - arr[i-1]; //0, 40, 10, 0, 0, 40, 25
            if (currentProfit > 0) {
                profit += currentProfit; //0, 40, 50, 50, 50, 90, 115
            }
        }
        return profit;
    }
}
