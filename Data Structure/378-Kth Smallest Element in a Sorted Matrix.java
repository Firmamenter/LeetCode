/**
378. Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.

Sol: Heap. 
*/

class Solution {
    private class Tri {
        int row; 
        int col; 
        int val; 
        
        Tri(int row, int col, int val) {
            this.row = row; 
            this.col = col; 
            this.val = val; 
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1; 
        }
        
        PriorityQueue<Tri> minHeap = new PriorityQueue<>(matrix.length, (a, b) -> a.val - b.val); 
        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new Tri(i, 0, matrix[i][0])); 
        }
        
        for (int i = 0; i < k - 1; i++) {
            Tri cur = minHeap.poll(); 
            if (cur.col + 1 < matrix[0].length) {
                minHeap.offer(new Tri(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1])); 
            }
        }
        
        return minHeap.poll().val; 
    }
}