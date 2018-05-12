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
// Time O(n * 2^n) Space O(n)
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

// Time O(n * 2^n) Space O(n)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null) {
            return res; 
        }
        Arrays.sort(nums); 
        boolean[] visited = new boolean[nums.length]; 
        helper(res, nums, 0, visited, new ArrayList<Integer>()); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int pos, boolean[] visited, List<Integer> list) {
        if (pos == nums.length) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        helper(res, nums, pos + 1, visited, list); 
        if (pos > 0 && nums[pos] == nums[pos - 1] && !visited[pos - 1]) {
            return; 
        }
        list.add(nums[pos]); 
        visited[pos] = true; 
        helper(res, nums, pos + 1, visited, list); 
        visited[pos] = false; 
        list.remove(list.size() - 1); 
    }
}