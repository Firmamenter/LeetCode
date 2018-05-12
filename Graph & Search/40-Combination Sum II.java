/**
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Solution: Similar to combination problem.
*/

// General version. Time O(n * 2^n) roughly.
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (candidates == null || candidates.length == 0) return res; 
        Arrays.sort(candidates); 
        boolean[] isUsed = new boolean[candidates.length]; 
        helper(res, candidates, new ArrayList<Integer>(), 0, 0, target, isUsed); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] candidates, List<Integer> list, int idx,
                        int sum, int target, boolean[] isUsed) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        if (sum > target) return; 
        for (int i = idx; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !isUsed[i - 1]) continue; 
            list.add(candidates[i]); 
            isUsed[i] = true; 
            helper(res, candidates, list, i + 1, sum + candidates[i], target, isUsed); 
            isUsed[i] = false; 
            list.remove(list.size() - 1); 
        }
    }
}

// Faster version. Time O(n * 2^n) roughly.
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (candidates == null || candidates.length == 0) return res; 
        Arrays.sort(candidates); 
        helper(res, candidates, new ArrayList<Integer>(), 0, 0, target); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] candidates, List<Integer> list, int idx, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        if (sum > target) return; 
        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]); 
            helper(res, candidates, list, i + 1, sum + candidates[i], target); 
            list.remove(list.size() - 1); 
            while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) i++; 
        }
    }
}