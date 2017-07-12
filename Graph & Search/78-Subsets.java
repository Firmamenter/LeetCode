/**
78. Subsets

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Solution: Need to sort first.
*/

//Time O(n * 2^n)
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        Arrays.sort(nums); 
        List<Integer> list = new ArrayList<>(); 
        res.add(new ArrayList<Integer>()); 
        helper(res, nums, list, 0); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int position) {
        if (position == nums.length) {
            return; 
        }
        
        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]); 
            res.add(new ArrayList<Integer>(list)); 
            helper(res, nums, list, i + 1); 
            list.remove(list.size() - 1); 
        }
    }
}