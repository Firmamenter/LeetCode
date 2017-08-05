/**
209. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

Solution: 1) O(n) two pointer. 2) O(nlogn) Binary Search. 
*/

// O(n)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s <= 0) {
            return 0; 
        }
        
        int left = 0; 
        int right = -1; 
        int sum = 0; 
        int minLen = Integer.MAX_VALUE; 
        while (right < nums.length || sum >= s) {
            if (sum >= s) {
                minLen = Math.min(minLen, right - left + 1); 
                sum -= nums[left]; 
                left++; 
            } else {
                right++; 
                if (right < nums.length) {
                    sum += nums[right]; 
                }
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen; 
    }
}

// O(nlogn)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s <= 0) {
            return 0; 
        }
        
        int[] sum = new int[nums.length]; 
        sum[0] = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i]; 
        }
        
        int minLen = Integer.MAX_VALUE; 
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == s) {
                minLen = i + 1; 
            } else if (sum[i] > s) {
                minLen = Math.min(i - findIndex(sum[i] - s, sum) + 1, minLen); 
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen; 
    }
    
    private int findIndex(int target, int[] sum) {
        int start = 0; 
        int end = sum.length - 1; 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; 
            if (sum[mid] == target) {
                return mid + 1; 
            } else if (sum[mid] > target) {
                end = mid; 
            } else {
                start = mid; 
            }
        }
        if (sum[start] > target) {
            return start; 
        } else if (sum[end] > target) {
            return end; 
        } else {
            return end + 1; 
        }
    }
}