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

Solution: DFS. 
*/
// Time: O(n*2^n) Space: O(n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        helper(res, nums, 0, new ArrayList<Integer>()); 
        res.add(new ArrayList<Integer>()); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int idx, List<Integer> level) {
        for (int i = idx; i < nums.length; i++) {  // 1.Iteration
            level.add(nums[i]);                    // 2.Add element
            res.add(new ArrayList<>(level));       // 3.Add list
            helper(res, nums, i + 1, level);       // 4.Recurse to next element
            level.remove(level.size() - 1);        // 5.Remove element
        }
    }
}

// Time: O(n*2^n) Space: O(n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null) {
            return res; 
        }
        helper(res, new ArrayList<Integer>(), nums, 0); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        helper(res, list, nums, index + 1); 
        list.add(nums[index]); 
        helper(res, list, nums, index + 1); 
        list.remove(list.size() - 1); 
    }
}

// New version. 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null) {
            return res; 
        }
        helper(res, new ArrayList<Integer>(), nums, 0); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        for (int i = index; i <= nums.length; i++) {
            if (i == nums.length) {
                helper(res, list, nums, i); 
                return; 
            }
            list.add(nums[i]); 
            helper(res, list, nums, i + 1); 
            list.remove(list.size() - 1); 
        }
    }
}