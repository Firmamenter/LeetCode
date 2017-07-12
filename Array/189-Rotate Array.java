/**
189. Rotate Array

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
*/

//Time O(nk), will exceed time limit.
public class Solution {
    public void rotate(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length <= 1) {
            return; 
        }
        k %= nums.length; 
        while (k > 0) {
            int end = nums[nums.length - 1]; 
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1]; 
            }
            nums[0] = end; 
            k--; 
        }
    }
}

//Reverse in 3 steps.
public class Solution {
    public void rotate(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length <= 1) {
            return; 
        }
        
        k %= nums.length; 
        
        reverse(nums, 0, nums.length - k - 1); 
        reverse(nums, nums.length - k, nums.length - 1); 
        reverse(nums, 0, nums.length - 1); 
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left]; 
            nums[left] = nums[right]; 
            nums[right] = temp; 
            left++; 
            right--; 
        }
    }
}

//