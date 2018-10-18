/**
LintCode: Continuous Subarray Sum

Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return the firstone you find)
Have you met this question in a real interview?  Yes
Problem Correction
Example
Give [-3, 1, 3, -3, 4], return [1,4].

Sol: Presum
*/
public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>(); 
        if (A == null || A.length == 0) {
            return res; 
        }
        int cur = A[0]; 
        int max = A[0]; 
        int maxIdx = 0; 
        for (int i = 1; i < A.length; i++) {
            cur = Math.max(cur, 0) + A[i]; 
            if (cur > max) {
                maxIdx = i; 
                max = cur; 
            }
        }
        int[] preSum = new int[maxIdx + 1]; 
        int sum = 0; 
        for (int i = 0; i < preSum.length; i++) {
            sum += A[i]; 
            preSum[i] = sum; 
        }
        int total = preSum[maxIdx]; 
        maxIdx = -1; 
        max = Integer.MIN_VALUE; 
        for (int i = 0; i < preSum.length; i++) {
            if (total - preSum[i] + A[i] > max) {
                maxIdx = i; 
                max = total - preSum[i] + A[i]; 
            }
        }
        res.add(maxIdx); 
        res.add(preSum.length - 1); 
        return res; 
    }
}