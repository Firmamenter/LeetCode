/**
213. House Robber II

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Solution: Choose either the first one or the last one. 
*/

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0; 
        if (nums.length == 1) return nums[0]; 
        if (nums.length == 2) return Math.max(nums[0], nums[1]); 
        int[] first = new int[2]; 
        int[] second = new int[2]; 
        first[0] = nums[0]; 
        first[1] = Math.max(nums[0], nums[1]); 
        second[0] = nums[1]; 
        second[1] = Math.max(nums[1], nums[2]); 
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = first[1]; 
            first[1] = Math.max(first[1], first[0] + nums[i]); 
            first[0] = temp; 
            temp = second[1]; 
            second[1] = Math.max(second[1], second[0] + nums[i + 1]); 
            second[0] = temp; 
        }
        return Math.max(first[1], second[1]); 
    }
}