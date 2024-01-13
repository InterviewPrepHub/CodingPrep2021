package Stack;

import java.util.Stack;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock
 * and we need to calculate span of stock’s price for all n days.
 *
 * The span S[i] of the stock’s price on a given day i is defined as the maximum number of consecutive days
 * (starting from today and going backward) for which the stock price was less than or equal to its price on day i.
 *
 * For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 *
 * Explanation
 *
 * Stock price    Max Consecutive days (starting from today) for which the stock price was
 *                less than or equal to the current price
 *
 * 100            1
 * 80             1
 * 60             1
 * 70             2
 * 60             1
 * 75             4
 * 85             6
 */
public class StockSpan {

    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] dp = new int[n];

        s.push(0);
        dp[0] = 1;

        for (int i=1;i<n;i++) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            dp[i] = s.isEmpty() ? i+1 : (i-s.peek());
            s.push(i);
        }

        for (int d : dp) {
            System.out.println(d);
        }
    }
}
