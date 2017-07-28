/**
LintCode: Coins in a Line II

There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Have you met this question in a real interview? Yes
Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false.

Soluton: DP. dp[i] means the largest amount we can get from values[i] to values[len - 1]. 
*/

public class Solution {
    /*
     * @param : a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false; 
        }
        int len = values.length; 
        if (len <= 2) {
            return true; 
        }
        int[] dp = new int[len + 1]; 
        dp[len - 1] = values[len - 1]; 
        dp[len - 2] = values[len - 1] + values[len - 2]; 
        dp[len - 3] = values[len - 2] + values[len - 3]; 
        int sum = values[len - 1] + values[len - 2] + values[len - 3]; 
        for (int i = len - 4; i >= 0; i--) {
            sum += values[i]; 
            dp[i] = values[i] + Math.min(dp[i + 2], dp[i + 3]); 
            dp[i] = Math.max(dp[i], values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4])); 
        }
        return 2 * dp[0] > sum; 
    }
};