/**
152. Maximum Product Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Solution: DP. 
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0]; 
        int max = nums[0]; 
        int min = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max; 
            int tempMin = min; 
            max = Math.max(tempMin * nums[i], Math.max(tempMax * nums[i], nums[i])); 
            min = Math.min(tempMin * nums[i], Math.min(tempMax * nums[i], nums[i])); 
            res = Math.max(res, max); 
        }
        return res; 
    }
}