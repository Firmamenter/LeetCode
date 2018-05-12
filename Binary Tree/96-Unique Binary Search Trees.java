/**
96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

Solution: Tree, DP. 
*/

class Solution {
    public int numTrees(int n) {
        if (n <= 0) return 0; 
        if (n == 1 || n == 2) return n; 
        int[][] dp = new int[n][n]; 
        for (int i = 0; i < n; i++) dp[i][i] = 1; 
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    if (k == i) dp[i][j] += dp[k + 1][j]; 
                    else if (k == j) dp[i][j] += dp[i][k - 1];  
                    else dp[i][j] += dp[i][k - 1] * dp[k + 1][j]; 
                }
            }
        }
        return dp[0][n - 1]; 
    }
}

// Improved version. 
class Solution {
    public int numTrees(int n) {
        if (n <= 0) return 0; 
        if (n == 1 || n == 2) return n; 
        int[] dp = new int[n]; 
        dp[0] = 1; 
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i] += dp[i - 1]; 
                else if (j == i) dp[i] += dp[i - 1]; 
                else dp[i] += dp[j - 1] * dp[i - j - 1]; 
            }
        }
        return dp[n - 1]; 
    }
}