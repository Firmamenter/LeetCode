/**
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

Solution: Use boolean array to record information.
*/

// Time O(n * n!) Space O(n)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        Arrays.sort(nums); 
        boolean[] visited = new boolean[nums.length]; 
        helper(res, new ArrayList<Integer>(), visited, nums); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue; 
            }
            visited[i] = true; 
            list.add(nums[i]); 
            helper(res, list, visited, nums); 
            list.remove(list.size() - 1); 
            visited[i] = false; 
        }
    }
}