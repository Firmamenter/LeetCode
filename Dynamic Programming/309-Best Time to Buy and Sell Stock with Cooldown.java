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

Sol: DP, Finite State Machine.
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0; 
        }
        int[] s0 = new int[prices.length]; 
        int[] s1 = new int[prices.length]; 
        int[] s2 = new int[prices.length]; 
        s0[0] = 0; 
        s1[0] = -prices[0]; 
        s2[0] = Integer.MIN_VALUE; 
        int n = prices.length; 
        for (int i = 1; i < n; i++) {
            s0[i] = s0[i - 1] > s2[i - 1] ? s0[i - 1] : s2[i - 1]; 
            s1[i] = s1[i - 1] > s0[i - 1] - prices[i] ? s1[i - 1] : s0[i - 1] - prices[i]; 
            s2[i] = s1[i - 1] + prices[i]; 
        }
        return s0[n - 1] > s1[n - 1] ? (s0[n - 1] > s2[n - 1] ? s0[n - 1] : s2[n - 1]) : (s1[n - 1] > s2[n - 1] ? s1[n - 1] : s2[n - 1]); 
    }
}