/**
55. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Solution: DP.
*/

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false; 
        }
        
        boolean[] res = new boolean[nums.length]; 
        res[0] = true; 
        for (int i = 1; i < nums.length; i++) {
            res[i] = false; 
            for (int j = i - 1; j >= 0; j--) {
                if (res[j] == true && j + nums[j] >= i) {
                    res[i] = true; 
                    break; 
                }
            }
        }
        
        return res[nums.length - 1]; 
    }
}