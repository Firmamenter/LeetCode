/**
LintCode: Backpack

Given n items with size A, an integer m denotes the size of a backpack. How full you can fill this backpack?

 Notice

You can not divide any item into small pieces.

Have you met this question in a real interview? Yes
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

Solution: DP. 
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0; 
        } 
        if (m <= 0) {
            return 0; 
        }
        int[][] dp = new int[A.length + 1][m + 1]; 
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0; 
        }
        for (int i = 1; i < A.length + 1; i++) {
            dp[i][0] = 0; 
        }
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + A[i - 1]); 
                } else {
                    dp[i][j] = dp[i - 1][j]; 
                }
            }
        }
        return dp[A.length][m]; 
    }
}