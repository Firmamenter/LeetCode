/**
540. Single Element in a Sorted Array

Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space.

Solution: Binary Search.
*/

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE; 
        }
        
        int start = 0; 
        int end = nums.length - 1; 
        while (start + 1< end) {
            int mid = start + (end - start) / 2; 
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                start = mid; 
            } else {
                end = mid; 
            }
        }
        
        // if (end == start) {
        //     return nums[start]; 
        // } else if (start == 0) {
        //     return nums[start]; 
        // } else if (nums[start] == nums[start - 1]) {
        //     return nums[end]; 
        // } else {
        //     return nums[start]; 
        // }
        if (start == 0) {
            return nums[start]; 
        } else {
            return nums[end]; 
        }
    }
}