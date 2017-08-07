/**
LintCode: Partition Array

Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

 Notice

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

Have you met this question in a real interview? Yes
Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

Solution: Two pointer. Fast and slow pointers. 
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int start = -1; 
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] < k) {
	            start++; 
	            int temp = nums[i]; 
	            nums[i] = nums[start]; 
	            nums[start] = temp; 
	        }
	    }
	    return start + 1; 
    }
}