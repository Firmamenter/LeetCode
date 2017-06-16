/**
128. Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Solution: Use hashset to store the existance of different elements; for each element in nums, check whether its next or previous element exists or not, if yes, max++ and delete its next or previous element.
          Similar idea to union find, we can group elements according to requirements.
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        
        int max = 1; 
        Set<Integer> set = new HashSet<>(); 
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]); 
        }
        
        for (int j = 0; j < nums.length; j++) {
            int cur = 1; 
            if (set.contains(nums[j])) {
                set.remove(nums[j]); 
                int next = nums[j] + 1; 
                while (set.contains(next)) {
                    cur++; 
                    set.remove(next); 
                    next++; 
                }
                int pre = nums[j] - 1; 
                while (set.contains(pre)) {
                    cur++; 
                    set.remove(pre); 
                    pre--; 
                }
            }
            max = (cur > max) ? cur : max; 
        }
        
        return max; 
    }
}