/**
188. Best Time to Buy and Sell Stock IV

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Solution: 1) If k is greater than the amount of transactions that can be made, just the method in II. 
          2) Otherwise, hold[i][j] means the maximum profit with at most j transaction for 0 to i-th day. 
          hold means you have a stock in your hand.
          unhold[i][j] means the maximum profit with at most j transaction for 0 to i-th day.
          unhold means you don't have a stock in your hand.
*/

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0; 
        }
        
        if (k > prices.length - 1) {
            return helper(prices); 
        }
        
        int[][] hold = new int[prices.length][k + 1]; 
        int[][] unhold = new int[prices.length][k + 1]; 
        for (int j = 0; j <= k; j++) {
            hold[0][j] = -prices[0]; 
        }
        for (int i = 1; i < prices.length; i++) {
            hold[i][0] = Math.max(hold[i - 1][0], -1 * prices[i]); 
        }
        
        for (int i = 1; i < prices.length; i++) {
            for(int j = 1; j <= k; j++) {
                hold[i][j] = Math.max(hold[i - 1][j], unhold[i - 1][j] - prices[i]); 
                unhold[i][j] = Math.max(unhold[i - 1][j], hold[i - 1][j - 1] + prices[i]); 
            }
        }
        
        return Math.max(hold[prices.length - 1][k], unhold[prices.length - 1][k]); 
    }
    
    private int helper(int[] prices) {
        int res = 0; 
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1]; 
            }
        }
        return res; 
    }
}