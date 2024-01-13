package Array.BuySellStocks;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one
share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/75931/easiest-java-solution-with-explanations/

 */

public class BuyAndSellStocksOverWithCoolDown {

    public static void main(String[] args) {

        int[] prices = {1,2,3,0,2};
        BuyAndSellStocksOverWithCoolDown b = new BuyAndSellStocksOverWithCoolDown();
        int max_profit = b.maxProfit(prices);
        System.out.println(max_profit);
    }

//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length <= 1) return 0;
//
//        /**
//         * Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
//         * Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]
//         *
//         *
//         * buy[i]: To make a decision whether to buy at i, we either take a rest, by just using the old decision at i - 1,
//         *         or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.
//         *
//         * sell[i]: To make a decision whether to sell at i, we either take a rest, by just using the old decision at i - 1,
//         *          or buy at/before i - 1, then sell at i.
//         */
//
//        int b0 = -prices[0], b1 = b0;
//        int s0 = 0, s1 = 0, s2 = 0;
//
//        for(int i = 1; i < prices.length; i++) {
//            b0 = Math.max(b1, s2 - prices[i]);
//            s0 = Math.max(s1, b1 + prices[i]);
//            b1 = b0; s2 = s1; s1 = s0;
//        }
//        return s0;
//    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] buy = new int[len + 1];
        int[] sell = new int[len + 1];
        buy[1] = -prices[0];
        for(int i = 2; i <= len; i++){
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
        }
        return sell[len];
    }
}
