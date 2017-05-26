/**
34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

Solution: Use Binary Search to find first and last target.
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1}; 
        }
        int[] result = new int[2]; 
        
        // Find the first target's position
        int start = 0; 
        int end = nums.length - 1; 
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (nums[mid] == target) {
                end = mid; 
            } else if (nums[mid] < target) {
                start = mid; 
            } else {
                end = mid; 
            }
        }
        if (nums[start] == target) {
            result[0] = start; 
        } else if (nums[end] == target) {
            result[0] = end; 
        } else {
            result[0] = -1; 
        }
        
        // Find the last target's position
        start = 0; 
        end = nums.length - 1; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (nums[mid] == target) {
                start = mid; 
            } else if (nums[mid] < target) {
                start = mid; 
            } else {
                end = mid; 
            }
        }
        if (nums[end] == target) {
            result[1] = end; 
        } else if (nums[start] == target) {
            result[1] = start; 
        } else {
            result[1] = -1; 
        }
        
        return result; 
    }
}