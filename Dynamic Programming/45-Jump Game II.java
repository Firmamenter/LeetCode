/**
45. Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

Solution: DP method will exceed time limit.
*/

public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        
        int[] steps = new int[nums.length]; 
        steps[0] = 0; 
        for (int i = 1; i < nums.length; i++) {
            steps[i] = Integer.MAX_VALUE; 
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    steps[i] = Math.min(steps[j] + 1, steps[i]); 
                }
            }
        }
        
        return steps[nums.length - 1]; 
    }
}