/**
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Solution: DP
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0; 
        }
        
        int row = grid.length; 
        int col = grid[0].length; 
        int[][] minPath = new int[row][col]; 
        
        minPath[0][0] = grid[0][0]; 
        for (int i = 1; i < col; i++) {
            minPath[0][i] = minPath[0][i - 1] + grid[0][i]; 
        }
        for (int j = 1; j < row; j++) {
            minPath[j][0] = minPath[j - 1][0] + grid[j][0]; 
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j]; 
            }
        }
        
        return minPath[row - 1][col - 1]; 
    }
}