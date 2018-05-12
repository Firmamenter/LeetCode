/**
287. Find the Duplicate Number

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

Solution: Binary search. (O(nlogn))  Cycle. (O(n))
*/
// Binary search. 
class Solution {
    public int findDuplicate(int[] nums) {
        int start = 1; 
        int end = nums.length - 1; 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; 
            int count = 0; 
            for (int element : nums) {
                if (element <= mid) {
                    count++; 
                }
            }
            if (count > mid) {
                end = mid; 
            } else {
                start = mid; 
            }
        }
        int count = 0; 
        for (int element : nums) {
            if (element <= start) {
                count++; 
            }
        }
        if (count > start) {
            return start; 
        } else {
            return end; 
        }
    }
}

// Cycle. 
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0]; 
        int fast = nums[nums[0]]; 
        while (slow != fast) {
            slow = nums[slow]; 
            fast = nums[nums[fast]]; 
        }
        int flag = 0; 
        while (flag != slow) {
            flag = nums[flag]; 
            slow = nums[slow]; 
        }
        return flag; 
    }
}