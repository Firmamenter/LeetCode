/**
53. Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

Solution: DP.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0]; 
        int dp = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            dp = nums[i] + Math.max(dp, 0); 
            max = Math.max(max, dp); 
        }
        return max; 
    }
}

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE; 
        }
        int max = nums[0]; 
        int[] dp = new int[2]; 
        dp[0] = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            dp[1] = Math.max(dp[0], 0) + nums[i]; 
            dp[0] = dp[1]; 
            max = Math.max(max, dp[0]); 
        }
        return max; 
    }
}