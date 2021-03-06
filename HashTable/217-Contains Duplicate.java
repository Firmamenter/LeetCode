/**
217. Contains Duplicate

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Solution: HashSet.
*/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false; 
        }
        Set<Integer> set = new HashSet<>(); 
        for (int num : nums) {
            if (!set.add(num)) {
                return true; 
            }
        }
        return false; 
    }
}