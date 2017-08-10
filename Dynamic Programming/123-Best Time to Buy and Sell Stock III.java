/**
123. Best Time to Buy and Sell Stock III

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Solution: DP. 
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1) {
            return 0; 
        }
        int len = prices.length; 
        int[] leftMaxProfit = new int[len]; 
        int[] rightMaxProfit = new int[len]; 
        int leftMin = prices[0]; 
        int rightMax = prices[len -1]; 
        for (int i = 1; i < len; i++) {
            leftMin = Math.min(leftMin, prices[i]); 
            rightMax = Math.max(rightMax, prices[len - 1 - i]); 
            leftMaxProfit[i] = Math.max(leftMaxProfit[i - 1], prices[i] - leftMin); 
            rightMaxProfit[len - 1 - i] = Math.max(rightMaxProfit[len - i], rightMax - prices[len - 1 - i]); 
        }
        int res = Math.max(leftMaxProfit[len - 1], rightMaxProfit[0]); 
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(res, leftMaxProfit[i] + rightMaxProfit[i + 1]); 
        }
        return res; 
    }
};