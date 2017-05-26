/**
154-Find Minimum in Rotated Sorted Array II

Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Solution: Because when we use Binary Search to spilt the original array, we can not leave out either sides, we have to consider both sides.
          So the wrost case is O(n), since we have to sweep the whole array.
*/

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE; 
        }
        int min = Integer.MAX_VALUE; 
        int i = 0; 
        for (; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i]; 
            }
        }
        return min; 
    }
}