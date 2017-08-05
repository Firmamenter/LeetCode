/**
LintCode: Two Sum - Closest to target

Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.

Have you met this question in a real interview? Yes
Example
Given array nums = [-1, 2, 1, -4], and target = 4.

The minimum difference is 1. (4 - (2 + 1) = 1).

Challenge 
Do it in O(nlogn) time complexity.

Solution: Sort, two pointer. 
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        int minDiff = Integer.MAX_VALUE; 
        int left = 0; 
        int right = nums.length - 1; 
        Arrays.sort(nums); 
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return 0; 
            } else if (nums[left] + nums[right] > target) {
                minDiff = Math.min(minDiff, nums[left] + nums[right] - target); 
                right--; 
            } else {
                minDiff = Math.min(minDiff, target - nums[left] - nums[right]); 
                left++; 
            }
        }
        return minDiff; 
    }
}