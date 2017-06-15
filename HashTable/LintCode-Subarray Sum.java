/**
LintCode: Subarray Sum

Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

Notice

There is at least one subarray that it's sum equals to zero.

Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].

Solution: Use HashTable to achieve O(n) time complexity.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>(); 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        
        Map<Integer, Integer> helpTable = new HashMap<>(); 
        int sum = 0; 
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            if (sum == 0) {
                res.add(0); 
                res.add(i); 
                return res; 
            }
            if (helpTable.containsKey(sum)) {
                res.add(helpTable.get(sum) + 1); 
                res.add(i); 
                return res; 
            } else {
                helpTable.put(sum, i); 
            }
        }
        return res; 
    }
}