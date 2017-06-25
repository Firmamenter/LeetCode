/**
15. 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

Solution: 1) Sort! 2) Two pointer. 3) Have to remove duplicate results.
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length < 3) {
            return res; 
        }
        
        Arrays.sort(nums); 
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; 
            }
            int s = i + 1; 
            int e = nums.length - 1; 
            while (s < e) {
                if (nums[i] + nums[s] + nums[e] == 0) {
                    List<Integer> temp = new ArrayList<>(); 
                    temp.add(nums[i]); 
                    temp.add(nums[s]); 
                    temp.add(nums[e]); 
                    res.add(temp);
                    s++; 
                    e--; 
                    while (s < e && nums[s] == nums[s - 1]) {
                        s++; 
                    }
                    while (s < e && nums[e] == nums[e + 1]) {
                        e--; 
                    }
                } else if (nums[i] + nums[s] + nums[e] > 0) {
                    e--; 
                    while (s < e && nums[e] == nums[e + 1]) {
                        e--; 
                    }
                } else {
                    s++; 
                    while (s < e && nums[s] == nums[s - 1]) {
                        s++; 
                    }
                }
            }
        }
        
        return res; 
    }
}