/**
52. N-Queens II

Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

Solution: Recursion + HashSet. 
*/

class Solution {
    private int count = 0; 
    private Set<Integer> col = new HashSet<>(); 
    private Set<Integer> diag = new HashSet<>(); 
    private Set<Integer> reDiag = new HashSet<>(); 
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0; 
        }
        helper(n, 0); 
        return count; 
    }
    
    private void helper(int n, int row) {
        if (row == n) {
            if (col.size() == n && diag.size() == n && reDiag.size() == n) {
                count++; 
            }
            return; 
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !diag.contains(row - i) && !reDiag.contains(row + i)) {
                col.add(i); 
                diag.add(row - i); 
                reDiag.add(row + i); 
                helper(n, row + 1); 
                col.remove(i); 
                diag.remove(row - i); 
                reDiag.remove(row + i); 
            }
        }
    } 
}