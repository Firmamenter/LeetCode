/**
33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Solution: BS. Divide the array into different parts.
*/

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; 
        }
        int start = 0; 
        int end = nums.length - 1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (nums[mid] == target) {
                return mid; 
            } else if (nums[0] < nums[mid]) {
                if (target < nums[mid] && target >= nums[0]) {
                    end = mid; 
                } else {
                    start = mid; 
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    start = mid; 
                } else {
                    end = mid; 
                }
            }
        }
        if (nums[start] == target) {
            return start; 
        } else if (nums[end] == target) {
            return end; 
        } else {
            return -1; 
        }
    }
}