/**
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Solution: DFS. 
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false; 
        }
        int row = board.length; 
        int col = board[0].length; 
        boolean[][] isVisited = new boolean[row][col]; 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isExist(board, word, isVisited, i, j, 0)) {
                    return true; 
                }
            }
        }
        return false; 
    }
    
    private boolean isExist(char[][] board, String word, boolean[][] isVisited, int row, int col, int len) {
        if (len == word.length()) {
            return true; 
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || isVisited[row][col] || board[row][col] != word.charAt(len)) {
            return false; 
        }
        int[] dr = {-1, 1, 0, 0}; 
        int[] dc = {0, 0, -1, 1}; 
        for (int i = 0; i < 4; i++) {
            isVisited[row][col] = true; 
            if (isExist(board, word, isVisited, row + dr[i], col + dc[i], len + 1)) {
                return true; 
            }
            isVisited[row][col] = false; 
        }
        return false; 
    }
}