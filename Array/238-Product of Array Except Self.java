/**
238. Product of Array Except Self

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

Solution: O(n) time, O(1) space.
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length]; 
        res[0] = 1; 
        int multiplier = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            res[i] = multiplier; 
            multiplier *= nums[i]; 
        }
        multiplier = nums[nums.length - 1]; 
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] *= multiplier; 
            multiplier *= nums[i]; 
        }
        return res; 
    }
}