/**
560. Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
Note:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

Sol: Presum
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length]; 
        int cnt = 0; 
        int sum = 0; 
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            preSum[i] = sum; 
            if (preSum[i] == k) {
                cnt++; 
            }
            if (map.containsKey(preSum[i] - k)) {
                cnt += map.get(preSum[i] - k); 
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1); 
        }
        return cnt; 
    }
}