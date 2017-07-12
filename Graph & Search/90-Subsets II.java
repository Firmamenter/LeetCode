/**
90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

Solution: Use boolean[] to store information.
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        boolean[] used = new boolean[nums.length]; 
        List<Integer> list = new ArrayList<>(); 
        Arrays.sort(nums); 
        res.add(new ArrayList<Integer>()); 
        helper(res, nums, used, list, 0); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> list, int position) {
        if (position == nums.length) {
            return; 
        }
        
        for (int i = position; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue; 
            }
            list.add(nums[i]); 
            used[i] = true; 
            res.add(new ArrayList<Integer>(list)); 
            helper(res, nums, used, list, i + 1); 
            used[i] = false; 
            list.remove(list.size() - 1); 
        }
    }
}