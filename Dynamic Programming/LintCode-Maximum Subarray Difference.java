/**
LintCode: Maximum Subarray Difference

Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

 Notice

The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
For [1, 2, -3, 1], return 6.

Challenge 
O(n) time and O(n) space.

Solution: DP. 
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int len = nums.length; 
        int[] leftMax = new int[len]; 
        int[] leftMin = new int[len]; 
        int[] rightMax = new int[len]; 
        int[] rightMin = new int[len]; 
        
        leftMax[0] = nums[0]; 
        leftMin[0] = nums[0]; 
        int endMax = nums[0]; 
        int endMin = nums[0]; 
        for (int i = 1; i < len; i++) {
            endMax = Math.max(endMax + nums[i], nums[i]); 
            leftMax[i] = Math.max(leftMax[i - 1], endMax); 
            
            endMin = Math.min(endMin + nums[i], nums[i]); 
            leftMin[i] = Math.min(leftMin[i - 1], endMin); 
        }
        
        rightMax[len - 1] = nums[len - 1]; 
        rightMin[len - 1] = nums[len - 1]; 
        int startMax = nums[len - 1]; 
        int startMin = nums[len - 1]; 
        for (int i = len - 2; i >= 0; i--) {
            startMax = Math.max(startMax + nums[i], nums[i]); 
            rightMax[i] = Math.max(rightMax[i + 1], startMax); 
            
            startMin = Math.min(startMin + nums[i], nums[i]); 
            rightMin[i] = Math.min(rightMin[i + 1], startMin); 
        }
        
        int res = Integer.MIN_VALUE; 
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(res, Math.abs(leftMax[i] - rightMin[i + 1])); 
            res = Math.max(res, Math.abs(leftMin[i] - rightMax[i + 1])); 
        }
        return res; 
    }
}

