/**
46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

Solution: DFS, permutation template. All leaf nodes are results.
*/

//Time O(n!) O(n*n!) O(n^2 * n!)
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        List<Integer> list = new ArrayList<>(); 
        helper(res, nums, list); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num); 
                helper(res, nums, list); 
                list.remove(list.size() - 1); 
            }
        }
    }
}