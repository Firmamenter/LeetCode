/**
130. Surrounded Regions

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X


Solution: BFS or DFS first to find regions against the border. 
*/

class Solution {
    private class Pair {
        int r; 
        int c; 
        
        Pair(int r, int c) {
            this.r = r; 
            this.c = c; 
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return; 
        }
        for (int r = 0; r < board.length; r++) {
            bfs(r, 0, board); 
            bfs(r, board[0].length - 1, board); 
        }
        for (int c = 0; c < board[0].length; c++) {
            bfs(0, c, board); 
            bfs(board.length - 1, c, board); 
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O'; 
                }
            }
        }
    }
    
    private void bfs(int row, int col, char[][] board) {
        if (board[row][col] != 'O') {
            return; 
        }
        board[row][col] = 'Y'; 
        int[] dr = {1, -1, 0, 0}; 
        int[] dc = {0, 0, 1, -1}; 
        Queue<Pair> queue = new LinkedList<>(); 
        queue.offer(new Pair(row, col)); 
        while (!queue.isEmpty()) {
            int len = queue.size(); 
            for (int i = 0; i < len; i++) {
                Pair cur = queue.poll(); 
                for (int j = 0; j < 4; j++) {
                    int r = cur.r + dr[j]; 
                    int c = cur.c + dc[j]; 
                    if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O') {
                        board[r][c] = 'Y'; 
                        queue.offer(new Pair(r, c)); 
                    }
                }
            }
        }
    }
}