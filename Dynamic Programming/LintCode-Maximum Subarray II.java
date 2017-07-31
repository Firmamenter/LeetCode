/**
LintCode: Maximum Subarray II

Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

 Notice

The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

SOlution: DP. 
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int[] dpLeft = new int[nums.size()]; 
        int[] dpLeftMax = new int[nums.size()]; 
        int[] dpRight  = new int[nums.size()]; 
        int[] dpRightMax = new int[nums.size()]; 
        dpLeft[0] = nums.get(0); 
        dpLeftMax[0] = nums.get(0); 
        for (int i = 1; i < nums.size(); i++) {
            dpLeft[i] = Math.max(dpLeft[i - 1], 0) + nums.get(i); 
            dpLeftMax[i] = Math.max(dpLeftMax[i - 1], dpLeft[i]); 
        }
        dpRight[nums.size() - 1] = nums.get(nums.size() - 1); 
        dpRightMax[nums.size() - 1] = nums.get(nums.size() - 1); 
        for (int i = nums.size() - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i + 1], 0) + nums.get(i); 
            dpRightMax[i] = Math.max(dpRightMax[i + 1], dpRight[i]); 
        }
        int res = Integer.MIN_VALUE; 
        for (int i = 0; i < nums.size() - 1; i++) {
            res = Math.max(res, dpLeftMax[i] + dpRightMax[i + 1]); 
        }
        return res; 
    }
}

