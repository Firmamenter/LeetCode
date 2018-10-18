/**
LintCode: Submatrix Sum

Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.
Have you met this question in a real interview?  Yes
Problem Correction
Example
Given matrix

[
  [1 ,5 ,7],
  [3 ,7 ,-8],
  [4 ,-8 ,9],
]
return [(1,1), (2,2)]
Challenge
O(n3) time.

Sol: Presum
*/

public class Solution {
    /*
     * @param matrix: an integer matrix
     * @return: the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][2]; 
        }
        int row = matrix.length; 
        int col = matrix[0].length; 
        int[][] colSum = new int[row][col]; 
        for (int j = 0; j < col; j++) {
            int sum = 0; 
            for (int i = 0; i < row; i++) {
                sum += matrix[i][j]; 
                colSum[i][j] = sum; 
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = i; j < row; j++) {
                int[] arr = new int[col]; 
                for (int k = 0; k < col; k++) {
                    arr[k] = colSum[j][k] - colSum[i][k] + matrix[i][k]; 
                }
                int[] subarrayIdx = findSubarraySum(arr); 
                if (subarrayIdx != null) {
                    int[][] res = new int[2][2]; 
                    res[0] = new int[]{i, subarrayIdx[0]}; 
                    res[1] = new int[]{j, subarrayIdx[1]}; 
                    return res; 
                }
            }
        }
        return new int[0][2]; 
    }
    
    private int[] findSubarraySum(int[] arr) {
        if (arr.length == 1 && arr[0] == 0) {
            return new int[]{0, 0}; 
        }
        int[] preSum = new int[arr.length]; 
        Map<Integer, Integer> map = new HashMap<>(); 
        preSum[0] = arr[0]; 
        map.put(preSum[0], 0); 
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i]; 
            if (preSum[i] == 0) {
                return new int[]{0, i}; 
            }
            if (map.containsKey(preSum[i])) {
                return new int[]{map.get(preSum[i]) + 1, i}; 
            } else {
                map.put(preSum[i], i); 
            }
        }
        return null; 
    }
}