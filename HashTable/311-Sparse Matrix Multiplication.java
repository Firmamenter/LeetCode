/**
311. Sparse Matrix Multiplication

Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int aRow = A.length; 
        int aCol = A[0].length; 
        int bRow = B.length; 
        int bCol = B[0].length; 
        
        Map<Integer, List<Integer>> aMap = new HashMap<>(); 
        for (int i = 0; i < aRow; i++) {
            List<Integer> list = new ArrayList<>(); 
            for (int j = 0; j < aCol; j++) {
                if (A[i][j] != 0) {
                    list.add(j); 
                }
            }
            aMap.put(i, list); 
        }
        
        int[][] res = new int[aRow][bCol];  
        for (int i = 0; i < aRow; i++) {
            List<Integer> list = aMap.get(i); 
            for (int j = 0; j < bCol; j++) {
                for (int k = 0; k < list.size(); k++) {
                    res[i][j] += A[i][list.get(k)] * B[list.get(k)][j]; 
                }
            }
        }
        return res; 
    }
}

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int aRow = A.length; 
        int aCol = A[0].length; 
        int bRow = B.length; 
        int bCol = B[0].length; 
        
        Map<Integer, List<Integer>> aMap = new HashMap<>(); 
        for (int i = 0; i < aRow; i++) {
            List<Integer> list = new ArrayList<>(); 
            for (int j = 0; j < aCol; j++) {
                if (A[i][j] != 0) {
                    list.add(j); 
                }
            }
            aMap.put(i, list); 
        }
        
        Map<Integer, List<Integer>> bMap = new HashMap<>(); 
        for (int i = 0; i < bRow; i++) {
            List<Integer> list = new ArrayList<>(); 
            for (int j = 0; j < bCol; j++) {
                if (B[i][j] != 0) {
                    list.add(j); 
                }
            }
            bMap.put(i, list); 
        }
        
        int[][] res = new int[aRow][bCol];  
        for (int i = 0; i < aRow; i++) {
            for (int k : aMap.get(i)) {
                for (int j : bMap.get(k)) {
                    res[i][j] += A[i][k] * B[k][j]; 
                }
            }
        }
        return res; 
    }
}