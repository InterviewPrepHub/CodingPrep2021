package Array.BuySellStocks;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Example 2:
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 * solution: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108871/2-solutions-2-states-dp-solutions-clear-explanation/
 */

public class BuyAndSellStockWithTransactionFee {

    /**
     * buy
     * sell
     *
     * base case:
     * buy[0] = - prices[0]; sell[0] = 0
     *
     * Status transformation:
     * At day i, we may buy stock (from previous sell status) or do nothing (from previous buy status):
     * buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
     * Or
     * At day i, we may sell stock (from previous buy status) or keep holding (from previous sell status):
     * sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
     *
     * We will return sell[last_day] as our result, which represents the max profit at the last day,
     */



    public static void main(String[] args) {

        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        int days = prices.length;
        int[] buy = new int[days];
        int[] sell = new int[days];

        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i=1;i<days;i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]-fee);
        }
        System.out.println(sell[days-1]);
    }
}
