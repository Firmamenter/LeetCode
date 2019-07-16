/**
977. Squares of a Sorted Array

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.

Sol: Two pointers. 
*/

class Solution {
    public int[] sortedSquares(int[] A) {
        if (A.length == 1) {
            return new int[]{(int)Math.pow(A[0], 2)}; 
        }
        int[] result = new int[A.length]; 
        int idx = A.length - 1; 
        int left = 0; 
        int right = A.length - 1; 
        while (left <= right) {
            if (Math.pow(A[left], 2) >= Math.pow(A[right], 2)) {
                result[idx--] = (int)Math.pow(A[left++], 2); 
            } else {
                result[idx--] = (int)Math.pow(A[right--], 2); 
            }
        }
        return result; 
    }
}