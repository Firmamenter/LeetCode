/**
309. Best Time to Buy and Sell Stock with Cooldown

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]

Sol: DP.
*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0; 
        }
        
        int len = prices.length; 
        int[] hold = new int[len]; 
        int[] unhold = new int[len]; 
        int[] cooldown = new int[len]; 
        
        hold[0] = -prices[0]; 
        
        for (int i = 1; i < len; i++) {
            hold[i] = Math.max(unhold[i - 1] - prices[i], hold[i - 1]); 
            unhold[i] = Math.max(cooldown[i - 1], unhold[i - 1]); 
            cooldown[i] = hold[i - 1] + prices[i]; 
        }
        
        return Math.max(hold[len - 1], Math.max(unhold[len - 1], cooldown[len - 1])); 
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0; 
        }
        
        int[] sell = new int[prices.length]; 
        int[] buy = new int[prices.length]; 
        sell[0] = 0; 
        buy[0] = -prices[0]; 
        
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]); 
            buy[i] = Math.max(buy[i - 1], ((i > 1) ? sell[i - 2] : 0) - prices[i]); 
        }
        return sell[prices.length - 1]; 
    }
}