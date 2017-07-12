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

Solution: Use hashmap to record information.
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1); 
            } else {
                map.put(num, map.get(num) + 1); 
            }
        }
        List<Integer> list = new ArrayList<>(); 
        helper(map, res, list, nums.length); 
        return res; 
    }
    
    private void helper(Map<Integer, Integer> map, List<List<Integer>> res, List<Integer> list, int length) {
        if (list.size() == length) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        
        for (Integer key : map.keySet()) {
            if (!list.contains(key) || map.get(key) != 0) {
                list.add(key); 
                map.put(key, map.get(key) - 1); 
                helper(map, res, list, length); 
                map.put(key, map.get(key) + 1); 
                list.remove(list.size() - 1); 
            }
        }
    }
}