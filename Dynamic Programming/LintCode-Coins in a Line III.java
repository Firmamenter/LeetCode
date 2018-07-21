/**
LintCode: Coins in a Line III

There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.

Could you please decide the first player will win or lose?

Have you met this question in a real interview? Yes
Example
Given array A = [3,2,2], return true.

Given array A = [1,2,4], return true.

Given array A = [1,20,4], return false.

Solution: dp[i][j] means the largest possible sum one player can get from i to j. 
*/
// 最大最小值方法
public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false; 
        }
        if (values.length == 1) {
            return true; 
        }
        int len = values.length; 
        int[][] dp = new int[len][len]; 
        int sum = 0; 
        for (int i = 0; i < len; i++) {
            dp[i][i] = values[i]; 
            sum += values[i]; 
        }
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (j == i + 1) {
                    dp[i][j] = Math.max(values[i], values[j]); 
                    continue; 
                }
                int left = values[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]); 
                int right = values[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]); 
                dp[i][j] = Math.max(left, right); 
            }
        }
        return 2 * dp[0][len - 1] > sum; 
    }
}

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false; 
        }
        int len = values.length; 
        int[][] dp = new int[len][len]; 
        int[] sum = new int[len]; 
        sum[0] = values[0]; 
        for (int i = 1; i < len; i++) {
            sum[i] = values[i] + sum[i - 1]; 
        }
        for (int i = 0; i < len; i++) {
            dp[i][i] = values[i]; 
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = sum[j] - sum[i] + values[i] - Math.min(dp[i + 1][j], dp[i][j - 1]); 
            }
        }
        return 2 * dp[0][len - 1] > sum[len - 1]; 
    }
}