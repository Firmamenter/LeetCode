/**
63. Unique Paths II

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

Solution: DP.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0; 
        }
        
        int row = obstacleGrid.length; 
        int col = obstacleGrid[0].length; 
        int[][] count = new int[row][col]; 
        
        if (obstacleGrid[0][0] != 1) {
            count[0][0] = 1; 
        }
        
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                count[i][0] = 0; 
            } else {
                count[i][0] = count[i - 1][0]; 
            }
        }
        
        for (int j = 1; j < col; j++) {
            if (obstacleGrid[0][j] == 1) {
                count[0][j] = 0; 
            } else {
                count[0][j] = count[0][j - 1]; 
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    count[i][j] = 0; 
                    continue; 
                } else {
                    count[i][j] = Math.max(count[i - 1][j], 0) + Math.max(count[i][j - 1], 0); 
                }
            }
        }
        
        return count[row - 1][col - 1]; 
    }
}