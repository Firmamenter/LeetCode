/**
137. Single Number II

Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Solution: Count the amount of each digit, then do mod. 
*/

public class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32]; 
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += nums[i] & 1; 
                nums[i] >>>= 1; 
            }
        }
        int res = 0; 
        for (int i = 31; i >= 0; i--) {
            res <<= 1; 
            res |= (count[i] % 3); 
        }
        return res; 
    }
}