/**
260. Single Number III

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

Solution: Bit Manipulation. 1) First find the different binary digit. 2) Divide array by that digit and do xor. 
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int media = 0; 
        for (int num : nums) {
            media ^= num; 
        }
        
        int pos = 0; 
        while ((media & 1) != 1) {
            media >>>= 1; 
            pos++; 
        }
        
        int[] res = new int[2]; 
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1 << pos) == (1 << pos)) {
                res[1] ^= nums[i]; 
            } else {
                res[0] ^= nums[i]; 
            }
        }
        return res; 
    }
}