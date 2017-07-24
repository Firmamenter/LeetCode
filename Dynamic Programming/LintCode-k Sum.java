/**
LintCode: k Sum

Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Have you met this question in a real interview? Yes
Example
Given [1,2,3,4], k = 2, target = 5.

There are 2 solutions: [1,4] and [2,3].

Return 2.

Solution: DP. Remember to initiate axes, not planes. 
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        // if (A == null || A.length == 0 || k <= 0 || target <= 0) {
        //     return 0; 
        // }
        int[][][] dp = new int[A.length + 1][k + 1][target + 1]; 
        for (int i = 0; i < A.length + 1; i++) {
            dp[i][0][0] = 1; 
        }
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                for (int t = 1; t < target + 1; t++) {
                    if (A[i - 1] <= t) {
                        dp[i][j][t] = dp[i - 1][j][t] + dp[i - 1][j - 1][t - A[i - 1]]; 
                    } else {
                        dp[i][j][t] = dp[i - 1][j][t]; 
                    }
                }
            }
        }
        return dp[A.length][k][target]; 
    }
}
