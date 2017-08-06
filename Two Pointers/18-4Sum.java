/**
18. 4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

Solution: Two pointers in the inner loop. Similar to 3Sum. 
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        Arrays.sort(nums); 
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; 
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; 
                }
                int left = j + 1; 
                int right = nums.length - 1; 
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> temp = new ArrayList<>(); 
                        temp.add(nums[i]); 
                        temp.add(nums[j]); 
                        temp.add(nums[left]); 
                        temp.add(nums[right]); 
                        res.add(temp); 
                        
                        left++; 
                        right--; 
                        while (left < nums.length - 1 && nums[left] == nums[left - 1]) {
                            left++; 
                        }
                        while (right > j + 1 && nums[right] == nums[right + 1]) {
                            right--; 
                        }
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--; 
                        while (right > j + 1 && nums[right] == nums[right + 1]) {
                            right--; 
                        }
                    } else {
                        left++; 
                        while (left < nums.length - 1 && nums[left] == nums[left - 1]) {
                            left++; 
                        }
                    }
                }
            }
        }
        
        return res; 
    }
}