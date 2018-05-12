/**
221. Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

Solution: (1)暴力解法，分别以每一个坐标为矩阵左上角，便利剩下右下所有点，时间复杂度O(n^4) 
          (2)DP解法，dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1
          为什么需要左上角，想象一下左边上边和左上分别为2，2，1的情况。时间复杂度O(n^2)，空间O(n^2)
          (3)因为只用到了上一层的数据，所以只用一行Array即可，节省空间。时间复杂度O(n^2)，空间O(n)
*/
// Time O(n^2)  Space O(n^2)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0; 
        int row = matrix.length; 
        int col = matrix[0].length; 
        int[][] dp = new int[row][col]; 
        int maxArea = 0; 
        for (int r = 0; r < row; r++) {
            dp[r][0] = matrix[r][0] == '1' ? 1 : 0; 
            maxArea = Math.max(maxArea, dp[r][0]); 
        }
        for (int c = 0; c < col; c++) {
            dp[0][c] = matrix[0][c] == '1' ? 1 : 0; 
            maxArea = Math.max(maxArea, dp[0][c]); 
        }
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (matrix[r][c] == '1') {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1; 
                    maxArea = Math.max(maxArea, dp[r][c]); 
                }
            }
        }
        return maxArea * maxArea; 
    }
}

// Time O(n^2)  Space O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0; 
        int row = matrix.length; 
        int col = matrix[0].length; 
        int[] dp = new int[col]; 
        int maxArea = 0; 
        for (int c = 0; c < col; c++) {
            dp[c] = matrix[0][c] == '1' ? 1 : 0; 
            maxArea = Math.max(maxArea, dp[c]); 
        }
        for (int r = 1; r < row; r++) {
            int pre = dp[0]; 
            dp[0] = matrix[r][0] == '1' ? 1 : 0; 
            maxArea = Math.max(maxArea, dp[0]); 
            for (int c = 1; c < col; c++) {
                if (matrix[r][c] == '1') {
                    int temp = Math.min(Math.min(dp[c], dp[c - 1]), pre) + 1; 
                    pre = dp[c]; 
                    dp[c] = temp; 
                    maxArea = Math.max(maxArea, dp[c]); 
                } else {
                    pre = dp[c]; 
                    dp[c] = 0; 
                }
            }
        }
        return maxArea * maxArea; 
    }
}