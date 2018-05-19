/**
162. Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Solution: BS, compare nums[mid] with nums[mid - 1] and nums[mid + 1]
          如果有重复数字的话，只能扫一遍，想象一下极端情况，[1, 1, 2, 1, 1, 1, 1]，二分时不知道改舍去哪边，只有从头到尾扫一遍
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; 
        }
        int start = 0; 
        int end = nums.length - 1; 
        int mid; 
        while (start + 1 < end) { // 保证了start一定比左边大，end一定比右边大
            mid = start + (end - start) / 2; 
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid; 
            } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid; 
            } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid; 
            } else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                end = mid; 
            }
        }
        if (nums[start] > nums[end]) { // start一定比左边大，end一定比右边大，所以target就在start和end中
            return start; 
        } else {
            return end; 
        }
    }
}