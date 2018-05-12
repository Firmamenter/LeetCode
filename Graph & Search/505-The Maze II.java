/**
505. The Maze II

There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

Solution: Since we have to find out the shortest path, we need to use BFS. 
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
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length; 
        int col = maze[0].length; 
        int[] dr = {1, -1, 0, 0}; 
        int[] dc = {0, 0, 1, -1}; 
        int[][] dist = new int[row][col]; 
        for (int i = 0; i < row; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE); 
        }
        dist[start[0]][start[1]] = 0; 
        Queue<Pair> queue = new LinkedList<>(); 
        queue.offer(new Pair(start[0], start[1])); 
        while (!queue.isEmpty()) {
            Pair cur = queue.poll(); 
            for (int i = 0; i < 4; i++) {
                int r = cur.r; 
                int c = cur.c; 
                int distance = dist[r][c]; 
                while (r >= 0 && r < row && c >= 0 && c < col && maze[r][c] != 1) {
                    r += dr[i]; 
                    c += dc[i]; 
                    distance++; 
                }
                r -= dr[i]; 
                c -= dc[i]; 
                distance--; 
                if (distance < dist[r][c]) {
                    dist[r][c] = distance; 
                    queue.offer(new Pair(r, c)); 
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]; 
    }
}