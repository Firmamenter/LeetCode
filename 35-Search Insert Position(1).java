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