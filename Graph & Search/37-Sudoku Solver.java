/**
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.

Sol: DFS. (1)Integer and Character conversion, you'd better use String as intermedia. 
          (2)You need to first record which numbers have been used. 
          (3)Since you are changing the board[][] during backtracking, you need to return result immediately when you find an answer.
*/

class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return; 
        boolean[][] row = new boolean[9][9]; 
        boolean[][] col = new boolean[9][9]; 
        boolean[][] block = new boolean[9][9]; 
        for (int i = 0; i < 9; i++) {
            Arrays.fill(row[i], true); 
            Arrays.fill(col[i], true); 
            Arrays.fill(block[i], true); 
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = Integer.valueOf(board[r][c] + "") - 1; 
                    row[r][num] = false; 
                    col[c][num] = false; 
                    block[(r / 3) * 3 + c / 3][num] = false; 
                }
            }
        }
        solver(board, row, col, block, 0); 
    }
    
    private boolean solver(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int startPoint) {
        if (startPoint >= 81) return true; 
        int r = startPoint / 9; 
        int c = startPoint % 9; 
        if (board[r][c] != '.') return solver(board, row, col, block, startPoint + 1); 
        for (int i = 0; i < 9; i++) {
            if (row[r][i] && col[c][i] && block[(r / 3) * 3 + c / 3][i]) {
                board[r][c] = (i + 1 + "").charAt(0); 
                row[r][i] = false; 
                col[c][i] = false; 
                block[(r / 3) * 3 + c / 3][i] = false; 
                if (solver(board, row, col, block, startPoint + 1)) return true; 
                board[r][c] = '.'; 
                row[r][i] = true; 
                col[c][i] = true; 
                block[(r / 3) * 3 + c / 3][i] = true; 
            }
        }
        return false; 
    }
}