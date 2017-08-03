/**
628. Maximum Product of Three Numbers

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

Soluton: Math. 
*/

public class Solution {
    public int maximumProduct(int[] nums) {
        int max1st = Integer.MIN_VALUE; 
        int max2nd = Integer.MIN_VALUE; 
        int max3rd = Integer.MIN_VALUE; 
        int min1st = Integer.MAX_VALUE; 
        int min2nd = Integer.MAX_VALUE; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max3rd) {
                max3rd = nums[i]; 
                if (nums[i] > max2nd) {
                    max3rd = max2nd; 
                    max2nd = nums[i]; 
                    if (nums[i] > max1st) {
                        max2nd = max1st; 
                        max1st = nums[i]; 
                    }
                }
            }
            if (nums[i] < min2nd) {
                min2nd = nums[i]; 
                if (nums[i] < min1st) {
                    min2nd = min1st; 
                    min1st = nums[i]; 
                }
            }
        }
        return Math.max(max1st * max2nd * max3rd, max1st * min1st * min2nd); 
    }
}