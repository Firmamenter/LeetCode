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

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (candidates == null || candidates.length == 0) {
            return res; 
        }
        Arrays.sort(candidates); 
        boolean[] isUsed = new boolean[candidates.length]; 
        List<Integer> list = new ArrayList<>(); 
        helper(res, candidates, list, isUsed, target, 0, 0); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] candidates, List<Integer> list, boolean[] isUsed, int target, int position, int sum) {
        if (sum > target) {
            return; 
        }
        if (sum == target) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        
        for (int i = position; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i] && !isUsed[i - 1]) {
                continue; 
            }
            if (sum < target) {
                list.add(candidates[i]); 
                isUsed[i] = true; 
                helper(res, candidates, list, isUsed, target, i + 1, sum + candidates[i]); 
                list.remove(list.size() - 1); 
                isUsed[i] = false; 
            }
        }
    }
}