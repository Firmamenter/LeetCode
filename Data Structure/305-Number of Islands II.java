/**
305. Number of Islands II

A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:

Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
Follow up:

Can you do it in time complexity O(k log mn), where k is the length of the positions?

Sol: Union-find
*/

class Solution {
    private class Element {
        int row; 
        int col; 
        Element(int row, int col) {
            this.row = row; 
            this.col = col; 
        }
    }
    
    private int count = 0; 
    private Element[][] father; 
    private int[][] size; 
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>(); 
        if (m <= 0 || n <= 0 || positions == null || positions.length == 0 || positions[0].length != 2) {
            return res; 
        }
        
        father = new Element[m][n]; 
        size = new int[m][n]; 
        int[] dr = {0, 0, 1, -1}; 
        int[] dc = {1, -1, 0, 0}; 
        for (int i = 0; i < positions.length; i++) {
            count++; 
            int r = positions[i][0]; 
            int c = positions[i][1]; 
            father[r][c] = new Element(r, c); 
            size[r][c] = 1; 
            for (int j = 0; j < 4; j++) {
                int newR = r + dr[j]; 
                int newC = c + dc[j]; 
                if (newR >= 0 && newR < m && newC >= 0 && newC < n && father[newR][newC] != null) {
                    union(father[r][c], father[newR][newC]); 
                }
            }
            res.add(count); 
        }
        
        return res; 
    }
    
    private Element find(Element e) {
        if (father[e.row][e.col] == e) {
            return e; 
        }
        father[e.row][e.col] = find(father[e.row][e.col]); 
        return father[e.row][e.col]; 
    }
    
    private void union(Element e1, Element e2) {
        Element father1 = find(e1); 
        Element father2 = find(e2); 
        if (father1 != father2) {
            if (size[father1.row][father1.col] >= size[father2.row][father2.col]) {
                father[father2.row][father2.col] = father1; 
                size[father1.row][father1.col] += size[father2.row][father2.col]; 
            } else {
                father[father1.row][father1.col] = father2; 
                size[father2.row][father2.col] += size[father1.row][father1.col]; 
            }
            count--; 
        }
    }
}