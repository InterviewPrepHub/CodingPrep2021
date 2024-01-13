package Array;

/*
Given an array of stock prices, find the maximum profit that can be earned by performing
multiple non-overlapping transactions (buy and sell)
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
