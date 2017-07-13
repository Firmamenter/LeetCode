/**
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

Solution: Similar to permutation problem, but be careful about the attacking rule.
*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>(); 
        if (n <= 0) {
            return res; 
        }
        List<List<Integer>> permutations = new ArrayList<>(); 
        List<Integer> list = new ArrayList<>(); 
        boolean[] isUsed = new boolean[n]; 
        Set<Integer> canAttackLeft = new HashSet<>(); 
        Set<Integer> canAttackRight = new HashSet<>(); 
        helper(permutations, n, isUsed, list, canAttackLeft, canAttackRight, 0); 
        res = draw(permutations); 
        return res; 
    }
    
    private void helper(List<List<Integer>> permutations, int n, boolean[] isUsed, List<Integer> list, Set<Integer> canAttackLeft, Set<Integer> canAttackRight, int row) {
        if (list.size() == n) {
            permutations.add(new ArrayList<Integer>(list)); 
            return; 
        }
        
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || (!isUsed[i] && !canAttackLeft.contains(i + row) && !canAttackRight.contains(i - row))) {
                list.add(i); 
                isUsed[i] = true; 
                canAttackLeft.add(i + row); 
                canAttackRight.add(i - row); 
                helper(permutations, n, isUsed, list, canAttackLeft, canAttackRight, row + 1); 
                isUsed[i] = false; 
                canAttackLeft.remove(i + row); 
                canAttackRight.remove(i - row); 
                list.remove(list.size() - 1); 
            }
        }
    }
    
    private List<List<String>> draw(List<List<Integer>> permutations) {
        List<List<String>> chessboards = new ArrayList<>(); 
        for (int i = 0; i < permutations.size(); i++) {
            List<String> chessboard = new ArrayList<>(); 
            for (int j = 0; j < permutations.get(0).size(); j++) {
                char[] temp = new char[permutations.get(0).size()]; 
                Arrays.fill(temp, '.'); 
                temp[permutations.get(i).get(j)] = 'Q'; 
                chessboard.add(new String(temp)); 
            }
            chessboards.add(chessboard); 
        }
        return chessboards; 
    }
}