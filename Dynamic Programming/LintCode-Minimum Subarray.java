/**
LintCode: Minimum Subarray

Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

 Notice

The subarray should contain one integer at least.

Have you met this question in a real interview? Yes
Example
For [1, -1, -2, 1], return -3.

Solution: Similar to maximum subarray. 
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int[] dp = new int[nums.size()]; 
        int minSum = nums.get(0); 
        dp[0] = nums.get(0); 
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = Math.min(dp[i - 1] + nums.get(i), nums.get(i)); 
            minSum = Math.min(minSum, dp[i]); 
        }
        return minSum; 
    }
}
