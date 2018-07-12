/**
407. Trapping Rain Water II

Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.

The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.


After the rain, water is trapped between the blocks. The total volume of water trapped is 4.

Sol: Heap + BFS. 思路参见http://www.cnblogs.com/grandyang/p/5928987.html. 
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
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0; 
        }
        int numOfRow = heightMap.length; 
        int numOfCol = heightMap[0].length; 
        boolean[][] isVisited = new boolean[numOfRow][numOfCol]; 
        PriorityQueue<Tri> minHeap = new PriorityQueue<>(numOfRow * numOfCol, (a, b) -> a.val - b.val); 
        for (int i = 0; i < numOfRow; i++) {
            minHeap.offer(new Tri(i, 0, heightMap[i][0])); 
            minHeap.offer(new Tri(i, numOfCol - 1, heightMap[i][numOfCol - 1])); 
            isVisited[i][0] = true; 
            isVisited[i][numOfCol - 1] = true; 
        }
        for (int i = 0; i < numOfCol; i++) {
            minHeap.offer(new Tri(0, i, heightMap[0][i])); 
            minHeap.offer(new Tri(numOfRow - 1, i, heightMap[numOfRow - 1][i])); 
            isVisited[0][i] = true; 
            isVisited[numOfRow - 1][i] = true; 
        }
        int area = 0; 
        int elevation = 0; 
        int[] dr = {0, 0, 1, -1}; 
        int[] dc = {1, -1, 0, 0}; 
        while (!minHeap.isEmpty()) {
            Tri cur = minHeap.poll(); 
            elevation = Math.max(elevation, cur.val); 
            for (int i = 0; i < 4; i++) {
                int newRow = cur.row + dr[i]; 
                int newCol = cur.col + dc[i]; 
                if (newRow >= 0 && newRow < numOfRow && newCol >= 0 && newCol < numOfCol 
                    && !isVisited[newRow][newCol]) {
                    isVisited[newRow][newCol] = true; 
                    minHeap.offer(new Tri(newRow, newCol, heightMap[newRow][newCol])); 
                    area += Math.max(elevation - heightMap[newRow][newCol], 0); 
                }
            }
        }
        return area; 
    }
}