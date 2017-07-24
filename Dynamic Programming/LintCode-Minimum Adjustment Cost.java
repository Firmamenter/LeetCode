/**
LintCode: Minimum Adjustment Cost

Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

 Notice

You can assume each number in the array is a positive integer and not greater than 100.

Have you met this question in a real interview? Yes
Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.

Solution: DP. 
*/

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int[][] dp = new int[A.size()][100]; 
        for (int j = 0; j < 100; j++) {
            dp[0][j] = Math.abs(A.get(0) - j - 1); 
        }
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = Integer.MAX_VALUE; 
                for (int k = Math.max(0, j - target); k < Math.min(100, j + target + 1); k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]); 
                }
                dp[i][j] += Math.abs(j + 1 - A.get(i)); 
            }
        }
        int res = Integer.MAX_VALUE; 
        for (int j = 0; j < 100; j++) {
            res = Math.min(res, dp[A.size() - 1][j]); 
        }
        return res; 
    }
}