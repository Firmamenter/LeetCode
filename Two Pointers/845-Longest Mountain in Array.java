/**
845. Longest Mountain in Array

Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain. 

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?

Sol: Two pointer. 
*/

class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0; 
        }
        int left = 0; 
        int right = 0; 
        int maxLen = 0; 
        while (right + 1 < A.length) {
            while (right + 1 < A.length && A[right + 1] <= A[right]) {
                right++; 
            }
            left = right; 
            while (right + 1 < A.length && A[right + 1] > A[right]) {
                right++; 
            }
            if (right + 1 < A.length && A[right + 1] == A[right]) {
                left = ++right; 
                continue; 
            }
            while (right + 1 < A.length && A[right + 1] < A[right]) {
                maxLen = Math.max(maxLen, right + 1 - left + 1); 
                right++; 
            }
            left = right; 
        }
        return maxLen; 
    }
}