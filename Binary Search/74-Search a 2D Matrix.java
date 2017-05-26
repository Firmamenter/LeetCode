/**
74. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

Solution: Binary Search.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; 
        }
        int row = matrix.length; 
        int col = matrix[0].length; 
        int start = 0; 
        int end = row * col - 1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (matrix[mid / col][mid % col] == target) {
                return true; 
            } else if (matrix[mid / col][mid % col] < target) {
                start = mid; 
            } else {
                end = mid; 
            }
        }
        if (matrix[start / col][start % col] == target) {
            return true; 
        } else if (matrix[end / col][end % col] == target) {
            return true; 
        } else {
            return false; 
        }
    }
}