/**
268. Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Solution: Math. Calculate sum and minus nums[i] one by one.
*/

// Math. 
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0; 
        }
        long sum = (nums.length * (nums.length + 1)) / 2; 
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i]; 
        }
        return (int)sum; 
    }
}

// Flipping. 
class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[Math.abs(nums[i]) - 1] *= -1; 
            }
        }
        int idx = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1; 
            }
            if (nums[i] == 0) {
                idx = i + 1; 
            }
        }
        return idx; 
    }
}