/**
485. Max Consecutive Ones

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

Solution: Two pointer.
*/

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0; 
        int left = -1; 
        int right = 0; 
        for (; right < nums.length; right++) {
            if (nums[right] == 0) { 
                len = Math.max(len, right - left - 1); 
                left = right; 
            }
        }
        if (right - left > 1) {
            len = Math.max(len, right - left - 1); 
        }
        return len; 
    }
}