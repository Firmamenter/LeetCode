/**
85. Maximal Rectangle

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

Solution: Translate the matrix into a histogram, then the rest is the same as Largest Histogram problem.
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0; 
        }
         
         //Translate the matrix.
         int row = matrix.length; 
         int col = matrix[0].length; 
         int[][] newMatrix = new int[row][col]; 
         for (int i = 0; i < row; i++) {
             for (int j = 0; j < col; j++) {
                 if (i == 0) {
                     newMatrix[i][j] = matrix[i][j] - '0'; 
                 } else {
                     if (matrix[i - 1][j] != '0' && matrix[i][j] != '0') { //Both have to be 1.
                         newMatrix[i][j] = newMatrix[i - 1][j] + 1; 
                     } else {
                         newMatrix[i][j] = matrix[i][j] - '0'; 
                     }
                 }
             }
         }
         
         int max = 0; 
         for (int[] r : newMatrix) {
             max = Math.max(max, findMaxArea(r)); 
         }
         
         return max;
    }
    
    private int findMaxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
}



