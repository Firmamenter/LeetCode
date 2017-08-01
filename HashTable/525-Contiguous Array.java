/**
525. Contiguous Array

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

Solution: Hash Table. 
*/

public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0; 
        }
        Map<Integer, Integer> map = new HashMap<>(); 
        int maxLen = 0; 
        int count0 = 0; 
        int count1 = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++; 
            } else {
                count1++; 
            }
            if (!map.containsKey(count1 - count0)) {
                map.put(count1 - count0, i); 
            } else {
                maxLen = Math.max(maxLen, i - map.get(count1 - count0)); 
            }
            if (count1 == count0) {
                maxLen = Math.max(maxLen, i + 1); 
            }
        }
        return maxLen; 
    }
}