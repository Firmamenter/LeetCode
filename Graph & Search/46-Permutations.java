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

// Time O(n^2 * n!) Space O(n)
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

// Time O(n * n!) Space O(n)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) return res; 
        Set<Integer> set = new HashSet<>(); 
        helper(nums, res, set, new ArrayList<Integer>(), 0); 
        return res; 
    }
    
    private void helper(int[] nums, List<List<Integer>> res, Set<Integer> set, List<Integer> list, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        for (int num : nums) {
            if (set.add(num)) {
                list.add(num); 
                helper(nums, res, set, list, idx + 1); 
                list.remove(list.size() - 1); 
                set.remove(num); 
            }
        }
    }
}

// Time O(n * n!) Space O(n)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        helper(res, nums, 0); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>(); 
            for (int num : nums) {
                list.add(num); 
            }
            res.add(list); 
            return; 
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i); 
            helper(res, nums, index + 1); 
            swap(nums, index, i); 
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start]; 
        nums[start] = nums[end]; 
        nums[end] = temp; 
    }
}