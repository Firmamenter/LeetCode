/**
75. Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Notice

You are not suppose to use the library's sort function for this problem. 
You should do it in-place (sort numbers in the original array).

Have you met this question in a real interview? Yes
Example
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].

Challenge 
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

Solution: Swap. Fast and slow pointers. 
          Usually there are two ways of using two-pointers method. 1) Fast and slow pointers.(Applied to general cases.) 2) Head and tail pointers.(Applied iff there are just two kinds of targets.) 
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int start = 0; 
        int end  = nums.length - 1; 
        int i = 0; 
        
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, i, start); 
                start++; 
                i++; 
            } else if (nums[i] == 1) {
                i++; 
            } else {
                swap(nums, i, end); 
                end--; 
            }
        }
        
        
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1]; 
        nums[index1] = nums[index2]; 
        nums[index2] = temp; 
    }
}