/**
LintCode: Median

Given a unsorted array with integers, find the median of it.

A median is the middle number of the array after it is sorted.

If there are even numbers in the array, return the N/2-th number after sorted.

Have you met this question in a real interview? Yes
Example
Given [4, 5, 1, 2, 3], return 3.

Given [7, 9, 4, 5], return 5.

Solution: Quick Select. O(n). 
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        return helper(nums, 0, nums.length - 1, (nums.length + 1) / 2); 
    }
    
    private int helper(int[] nums, int start, int end, int size) {
        int mid = start; 
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[start]) {
                mid++; 
                int temp = nums[i]; 
                nums[i] = nums[mid]; 
                nums[mid] = temp; 
            }
        }
        int temp = nums[mid]; 
        nums[mid] = nums[start]; 
        nums[start] = temp; 
        if (mid - start + 1 == size) {
            return nums[mid]; 
        } else if (mid - start + 1 > size) {
            return helper(nums, start, mid - 1, size); 
        } else {
            return helper(nums, mid + 1, end, size - (mid - start + 1)); 
        }
    }
}
