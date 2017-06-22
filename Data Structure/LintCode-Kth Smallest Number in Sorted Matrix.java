/**
LintCode: Kth Smallest Number in Sorted Matrix

Find the kth smallest number in at row and column sorted matrix.

Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5

Solve it in O(k log n) time where n is the bigger one between row size and column size.

Solution: Max heap.
*/

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    private class Tri {
        int row; 
        int col; 
        int val; 
        Tri (int row, int col, int val) {
            this.row = row; 
            this.col = col; 
            this.val = val; 
        }
    }
     
    PriorityQueue<Tri> max; 
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1; 
        }
        
        max = new PriorityQueue<>(matrix.length, new Comparator<Tri>() {
            public int compare(Tri a, Tri b) {
                return a.val - b.val; 
            }
        });
        
        for (int i = 0; i < matrix.length; i++) {
            max.offer(new Tri(i, 0, matrix[i][0])); 
        }
        
        for (int i = 0; i < k - 1; i++) {
            Tri temp = max.poll(); 
            if (temp.col < matrix[0].length - 1) {
                max.offer(new Tri(temp.row, temp.col + 1, matrix[temp.row][temp.col + 1])); 
            }
        }
        
        return max.poll().val; 
    }
}