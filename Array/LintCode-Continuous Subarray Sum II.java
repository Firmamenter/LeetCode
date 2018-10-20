/**
403. Continuous Subarray Sum II

Description
Given an circular integer array (the next element of the last element is the first element), find a continuous subarray in it, where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number.

If duplicate answers exist, return any of them.
Have you met this question in a real interview?  Yes
Problem Correction
Example
Give [3, 1, -100, -3, 4], return [4,1].
Challenge
Do it in 
O
(
n
)
O(n) time

Sol: First find max subarray and min subarray, then compare max and sum - min to decide which way you are gonna use to get the max subarray. 
*/

public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySumII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>(); 
        if (A == null || A.length == 0) {
            return res; 
        }
        int maxIdx = 0; 
        int max = Integer.MIN_VALUE; 
        int preMax = 0; 
        int minIdx = 0; 
        int min = Integer.MAX_VALUE; 
        int preMin = 0; 
        int sum = 0; 
        int[] preSum = new int[A.length]; 
        for (int i = 0; i < A.length; i++) {
            sum += A[i]; 
            preSum[i] = sum; 
            preMax = Math.max(preMax, 0) + A[i]; 
            if (preMax > max) {
                max = preMax; 
                maxIdx = i; 
            }
            preMin = Math.min(preMin, 0) + A[i]; 
            if (preMin < min) {
                min = preMin; 
                minIdx = i; 
            }
        }
        if (max >= sum - min || sum == min) {
            for (int i = 0; i <= maxIdx; i++) {
                if (preSum[maxIdx] - preSum[i] + A[i] == max) {
                    res.add(i); 
                    res.add(maxIdx); 
                    break; 
                }
            }
        } else {
            for (int i = 0; i <= minIdx; i++) {
                if (preSum[minIdx] - preSum[i] + A[i] == min) {
                    res.add(minIdx + 1); 
                    res.add(i - 1); 
                    break; 
                }
            }
        }
        return res; 
    }
}
// 首先求出非循环的最大子序列和非循环的最小子序列。

// 非循环的最小子序列中的结尾如果是正数，那么一定只有一个数，且数组全是正数，
// 这种情况下 max > sum - min；

// 如果是负数，子序列中可能还有正数，但是两端一定是负数，
// 这种情况下非循环最大子序列一定不包含任何非循环最小子序列中的任意元素，
// 此时如果非循环最小子序列在数组两端的话，max >= sum - min，
// 如果非循环最小子序列在数组中间的话，max和sum - min的大小就需要比较了。

// 还有一种极端情况，数组全是负数需要特殊处理。