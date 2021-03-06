/**
39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

Solution: The most significant thing is to construct depth search tree.
*/

// Time O(n * 2^n) roughly. 解域宽扁 Space O(n)
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (candidates == null || candidates.length == 0) {
            return res; 
        }
        List<Integer> list = new ArrayList<>(); 
        helper(res, candidates, target, list, 0, 0); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> list, int position, int sum) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        
        for (int i = position; i < candidates.length; i++) {
            if (sum < target) {
                list.add(candidates[i]); 
                helper(res, candidates, target, list, i, sum + candidates[i]); 
                list.remove(list.size() - 1); 
            }
        }
    }
}

// Time O(n * 2^n) roughly. 解域深长 Space O(n)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (candidates == null || candidates.length == 0) return res; 
        helper(candidates, res, new ArrayList<Integer>(), target, 0, 0); 
        return res; 
    }
    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        if (idx == candidates.length || sum > target) return; 
        list.add(candidates[idx]); 
        helper(candidates, res, list, target, sum + candidates[idx], idx); 
        list.remove(list.size() - 1); 
        helper(candidates, res, list, target, sum, idx + 1); 
    }
}