/**
LintCode: Burst Ballons

Description
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
你可以假设nums[-1] = nums[n] = 1
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Have you met this question in a real interview?  Yes
Example
Given [4, 1, 5, 10]
Return 270

nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
nums = [4, 5, 10]    burst 5, get coins 4 * 5 * 10 = 200 
nums = [4, 10]       burst 4, get coins 1 * 4 * 10 = 40
nums = [10]          burst 10, get coins 1 * 10 * 1 = 10

Total coins 20 + 200 + 40 + 10 = 270

Sol: DP. 
*/

public class Solution {
    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        int len = nums.length; 
        if (len == 1) {
            return nums[0]; 
        }
        int[][] dp = new int[len][len]; 
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i][i] = nums[0] * nums[1]; 
            } else if (i == len - 1) {
                dp[i][i] = nums[i - 1] * nums[i]; 
            } else {
                dp[i][i] = nums[i - 1] * nums[i] * nums[i + 1]; 
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                for (int k = i; k <= j; k++) {
                    int left = i == 0 ? 1 : nums[i - 1]; 
                    int leftDP = k == 0 ? 0 : dp[i][k - 1]; 
                    int right = j == len - 1 ? 1 : nums[j + 1]; 
                    int rightDP = k == len - 1 ? 0 : dp[k + 1][j]; 
                    dp[i][j] = Math.max(dp[i][j], 
                    leftDP + rightDP + left * nums[k] * right); 
                }
            }
        }
        return dp[0][len - 1]; 
    }
}

