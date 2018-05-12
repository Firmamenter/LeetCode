/**
322. Coin Change

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

Solution: DP. 如果要输出最优解中每个coin用多少个，可以再用一个value矩阵记录.
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) return -1; 
        int[][] dp = new int[coins.length + 1][amount + 1]; 
        for (int i = 0; i < dp.length; i++) dp[i][0] = 0; 
        for (int j = 1; j < dp[0].length; j++) dp[0][j] = Integer.MAX_VALUE; 
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j || dp[i][j - coins[i - 1]] == Integer.MAX_VALUE) dp[i][j] = dp[i - 1][j]; 
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1); 
            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount]; 
    }
}