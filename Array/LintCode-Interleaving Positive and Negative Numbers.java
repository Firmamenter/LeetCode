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
public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return; 
        }
        int left = 0, right = 1, posCnt = 0, firstPos = Integer.MAX_VALUE, firstNeg = Integer.MAX_VALUE; 
        boolean findPos = false, findNeg = false; 
        for (int i = 0; i < A.length; i++) {
            if (!findPos && A[i] > 0) {
                firstPos = i; 
                findPos = true; 
            }
            if (!findNeg && A[i] < 0) {
                firstNeg = i; 
                findNeg = true; 
            }
            posCnt += A[i] > 0 ? 1 : 0; 
        }
        if (posCnt * 2 > A.length && A[0] < 0 || posCnt * 2 < A.length && A[0] > 0) {
            swap(firstNeg, firstPos, A); 
        }
        left = 0;
        right = 1;  
        while (right < A.length) {
            if (A[right] * A[left] < 0) {
                swap(++left, right, A); 
                while (left + 1 < A.length && A[left] * A[left + 1] < 0) {
                    left++; 
                }
                if (left > right) {
                    right = left; 
                }
            }
            right++; 
        }
    }
    
    private void swap(int left, int right, int[] A) {
        int temp = A[left]; 
        A[left] = A[right]; 
        A[right] = temp; 
    }
}

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