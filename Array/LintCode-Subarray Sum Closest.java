/**
LintCode: Subarray Sum Closest

Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Have you met this question in a real interview? Yes
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

Challenge 
O(nlogn) time

Solution: Array. Sort. 
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0]; 
        }
        
        int[] res = new int[2]; 
        Map<Integer, Integer> map = new HashMap<>(); 
        int[] sum = new int[nums.length]; 
        sum[0] = nums[0]; 
        map.put(nums[0], 0); 
        for (int i = 1; i < nums.length; i++) {
            sum[i] += sum[i - 1] + nums[i]; 
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], i); 
            } else {
                res[0] = map.get(sum[i]) + 1; 
                res[1] = i; 
                return res; 
            }
        }
        
        Arrays.sort(sum); 
        int min = Integer.MAX_VALUE; 
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] - sum[i - 1] < min) {
                res[0] = Math.min(map.get(sum[i]), map.get(sum[i - 1])) + 1; 
                res[1] = Math.max(map.get(sum[i]), map.get(sum[i - 1])); 
                min = sum[i] - sum[i - 1]; 
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < min) {
                res[0] = i; 
                res[1] = i; 
                min = Math.abs(nums[i]); 
            }
        }
        
        return res; 
    }
}
