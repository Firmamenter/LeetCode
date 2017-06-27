/**
26. Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

Solution: Two pointer. 
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        
        int j = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i]; 
            }
        }
        
        return ++j; 
    }
}

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        
        int start = 0; 
        int end = 0; 
        for (int i = 1; i < nums.length;) {
            if (nums[i] != nums[i - 1]) {
                i++; 
                continue; 
            }
            start = i; 
            while (i < nums.length && nums[i] == nums[i - 1]) {
                end = i; 
                i++; 
            }
            for (int j = start; j <= end; j++) {
                nums[j] = Integer.MIN_VALUE; 
            }
        }
        
        int left = 0; 
        int right = 0; 
        while (right < nums.length) {
            if (nums[left] != Integer.MIN_VALUE && nums[right] != Integer.MIN_VALUE) {
                left++; 
                right++; 
            } else if (nums[left] == Integer.MIN_VALUE && nums[right] == Integer.MIN_VALUE) {
                right++; 
            } else if (nums[left] == Integer.MIN_VALUE && nums[right] != Integer.MIN_VALUE) {
                int temp = nums[left]; 
                nums[left] = nums[right]; 
                nums[right] = temp; 
                left++; 
                right++; 
            }
        }
        
        return left; 
    }
}