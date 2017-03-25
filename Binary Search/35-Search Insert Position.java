/**
35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Solution: Binary Search. Please remember this template.
*/


public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0; 
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i; 
            }
        }
        return nums.length;
    }
}

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left + 1 < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle; 
            }
            else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle; 
            }
        }
        
        if (nums[left] >= target) {
            return left; 
        } else if (nums[right] >= target) {
            return right; 
        } else {
            return nums.length; 
        }
    }
}