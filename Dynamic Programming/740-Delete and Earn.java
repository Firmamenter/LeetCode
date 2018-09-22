/**
740. Delete and Earn

Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:
Input: nums = [3, 4, 2]
Output: 6
Explanation: 
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.
Example 2:
Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation: 
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.
Note:

The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].

Solution: DP. 
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        Arrays.sort(nums); 
        int curSum = 0; 
        int preSum = 0; 
        int prePreSum = 0; 
        int cur = 0; 
        int pre = -1; 
        while (cur < nums.length) {
            pre = cur - 1; 
            int sum = nums[cur++]; 
            while (cur < nums.length && nums[cur] == nums[cur - 1]) {
                sum += nums[cur++]; 
            }
            if (pre >= 0 && nums[cur - 1] > nums[pre] + 1) {
                curSum = sum + preSum; 
            } else {
                curSum = Math.max(preSum, sum + prePreSum); 
            }
            prePreSum = preSum; 
            preSum = curSum; 
        }
        return curSum; 
    }
}


class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0; 
        Arrays.sort(nums); 
        int curSum = 0; 
        int preSum = 0; 
        int prePreSum = 0; 
        int preIdx = 0; 
        int idx = 0; 
        
        while (idx < nums.length) {
            preIdx = idx - 1; 
            curSum = nums[idx]; 
            while (idx < nums.length - 1 && nums[idx] == nums[idx + 1]) curSum += nums[idx++]; 
            if (preIdx >= 0 && nums[idx] > nums[preIdx] + 1) curSum += preSum; 
            else curSum = Math.max(preSum, prePreSum + curSum); 
            
            prePreSum = preSum; 
            preSum = curSum; 
            idx++; 
        }
        
        return curSum; 
    }
}