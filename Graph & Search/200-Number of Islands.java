/**
200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

Solution: DFS or BFS. 
*/

// DFS version
class Solution {
    private int count = 0; 
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0; 
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++; 
                    dfs(grid, i, j); 
                }
            }
        }
        return count; 
    }
    
    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0'; 
        int[] dx = {1, -1, 0, 0}; 
        int[] dy = {0, 0, 1, -1}; 
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i]; 
            int newCol = col + dy[i]; 
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == '0') {
                continue; 
            }
            dfs(grid, newRow, newCol); 
        }
    }
}

// BFS Version
class Solution {
    private int count = 0; 
    
    private class Pair {
        int r; 
        int c; 
        
        Pair(int r, int c) {
            this.r = r; 
            this.c = c; 
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++; 
                    bfs(i, j, grid); 
                }
            }
        }
        return count; 
    }
    
    private void bfs(int row, int col, char[][] grid) {
        grid[row][col] = '0'; 
        int[] dr = {1, -1, 0, 0}; 
        int[] dc = {0, 0, 1, -1}; 
        Queue<Pair> queue = new LinkedList<>(); 
        queue.offer(new Pair(row, col)); 
        while (!queue.isEmpty()) {
            int len = queue.size(); 
            for (int i = 0; i < len; i++) {
                Pair cur = queue.poll(); 
                for (int j = 0; j < 4; j++) {
                    int newR = cur.r + dr[j]; 
                    int newC = cur.c + dc[j]; 
                    if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == '1') {
                        grid[newR][newC] = '0'; 
                        queue.offer(new Pair(newR, newC)); 
                    }
                }
            }
        }
    }
}