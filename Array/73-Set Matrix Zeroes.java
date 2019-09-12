/**
73. Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Sol: Array.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return; 
        }
        int rowLen = matrix.length; 
        int colLen = matrix[0].length; 
        Set<Integer> rowRecord = new HashSet<>(); 
        Set<Integer> colRecord = new HashSet<>(); 
        for (int i = 0; i <  rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord.add(i); 
                    colRecord.add(j); 
                }
            }
        }
        for (int row: rowRecord) {
            Arrays.fill(matrix[row], 0); 
        }
        for (int col: colRecord) {
            for (int i = 0; i < rowLen; i++) {
                matrix[i][col] = 0; 
            }
        }
    }
}

// Using first row and col to record instead of using two sets. 
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return; 
        }
        boolean isFirstRow = false; 
        boolean isFirstCol = false; 
        int rowLen = matrix.length; 
        int colLen = matrix[0].length; 
        for (int i = 0; i <  rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        isFirstRow = true; 
                        isFirstCol = true; 
                    } else if (i == 0) {
                        isFirstRow = true; 
                    } else if (j == 0) {
                        isFirstCol = true; 
                    }
                    matrix[i][0] = 0; 
                    matrix[0][j] = 0; 
                }
            }
        }
        for (int i = rowLen - 1; i > 0; i--) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < colLen; j++) {
                    matrix[i][j] = 0; 
                }
            }
        }
        for (int j = colLen - 1; j > 0; j--) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < rowLen; i++) {
                    matrix[i][j] = 0; 
                }
            }
        }
        if (isFirstRow && isFirstCol) {
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0; 
            }
            for (int j = 0; j < colLen; j++) {
                matrix[0][j] = 0; 
            }
        } else if (isFirstRow) {
            for (int j = 0; j < colLen; j++) {
                matrix[0][j] = 0; 
            }
        } else if (isFirstCol) {
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0; 
            }
        }
    }
}