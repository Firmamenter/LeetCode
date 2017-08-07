/**
LintCode: Interleaving Positive and Negative Numbers

Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.

 Notice

You are not necessary to keep the original order of positive integers or negative integers.

Have you met this question in a real interview? Yes
Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.

Challenge 
Do it in-place and without extra memory.

Solution: Swap. 
*/

class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        int left = 0; 
        int right = A.length - 1; 
        while (left < right) {
            while (left < A.length - 1 && A[left] < 0) {
                left++; 
            }
            while (right > 0 && A[right] > 0) {
                right--; 
            }
            if (left < right) {
                swap(A, left, right); 
                left++; 
                right--; 
            }
        }
        int start = (left * 2 < A.length) ? 0 : 1; 
        swap(A, left, start); 
        left++; 
        start++; 
        while (start < A.length && left < A.length) {
            if ((long)A[start] * (long)A[start - 1] > 0) {
                swap(A, start, left); 
                start++; 
                left++; 
            } else {
                start++; 
            }
        }
   }
   
   private void swap(int[] A, int index1, int index2) {
       int temp = A[index1]; 
       A[index1] = A[index2]; 
       A[index2] = temp; 
   }
}