/**
498. Diagonal Traverse

Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:

Note:
The total number of elements of the given matrix will not exceed 10,000.

Solution: Math. 
*/

// Time O(m * n)    Space O(m * n)
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0]; 
        }
        int row = matrix.length; 
        int col = matrix[0].length; 
        int[] res = new int[row * col]; 
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!map.containsKey(i + j)) {
                    List<Integer> list = new ArrayList<>(); 
                    list.add(matrix[i][j]); 
                    map.put(i + j, list); 
                } else {
                    map.get(i + j).add(matrix[i][j]); 
                }
            }
        }
        int index = 0; 
        int flag = 0; 
        for (int i = 0; i <= row + col - 2; i++) {
            flag++; 
            List<Integer> temp = map.get(i); 
            if (flag % 2 == 1) {
                Collections.reverse(temp); 
            }
            for (int num : temp) {
                res[index++] = num; 
            }
        }
        return res; 
    }
}

// Time O(m * n)    Space O(1)
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0]; 
        }
        int row = matrix.length; 
        int col = matrix[0].length; 
        int[] res = new int[row * col]; 
        int r = 0; 
        int c = 0; 
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c]; 
            // Moving up. 
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    r++; 
                } else if (r == 0) {
                    c++; 
                } else {
                    r--; 
                    c++; 
                }
            } else { // Moving down. 
                if (r == row - 1) {
                    c++; 
                } else if (c == 0) {
                    r++; 
                } else {
                    r++; 
                    c--; 
                }
            }
        }
        return res; 
    }
} 