/**
16. 3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Solution: Two pointers in a loop. Similar to 3Sum. 
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); 
        int sum = 0; 
        int minDiff = Integer.MAX_VALUE; 
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; 
            int right = nums.length - 1; 
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == target) {
                    return nums[i] + nums[left] + nums[right]; 
                } else if (nums[i] + nums[left] + nums[right] > target) {
                    if (nums[i] + nums[left] + nums[right] - target < minDiff) {
                        minDiff = nums[i] + nums[left] + nums[right] - target; 
                        sum = nums[i] + nums[left] + nums[right]; 
                    }
                    right--; 
                } else {
                    if (target - nums[i] - nums[left] - nums[right] < minDiff) {
                        minDiff = target - nums[i] - nums[left] - nums[right]; 
                        sum = nums[i] + nums[left] + nums[right]; 
                    }
                    left++; 
                }
            }
        }
        return sum; 
    }
}