/**
300. Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

Solution: DP.
*/
//Time: O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        
        int[] res = new int[nums.length]; 
        res[0] = 1; 
        for (int i = 1; i < nums.length; i++) {
            res[i] = 1; 
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1); 
                }
            }
        }
        
        int max = Integer.MIN_VALUE; 
        for (int i = 0; i < res.length; i++) {
            max = Math.max(res[i], max); 
        }
        
        return max; 
    }
}