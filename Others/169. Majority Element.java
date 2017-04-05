/**
169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Sol: 1) Sorting the array and the majority element will definately locate at [nums.length / 2]th place.
     2) HashMap: count and find max.
     3) Moore Voting: The amount of majority elements shall be greater than [nums.length / 2] for using Moore Voting.
*/

// Sorting: Time O(nlogn) Space O(1)
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums); 
        return nums[nums.length / 2]; 
    }
}

// HashMap: Time O(n) Space O(n)
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }
        int res = 0; 
        int con = 0; 
        Set<Integer> keySet = count.keySet(); 
        for (Integer key : keySet) {
            if (count.get(key) > con) {
                con = count.get(key); 
                res = key; 
            }
        }
        return res; 
    }
}

// Moore Voting: Time O(n) Space O(1)
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 1; 
        int res = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i]; 
                count++; 
            } else if (res == nums[i]) {
                count++; 
            } else {
                count--; 
            }
        }
        return res; 
    }
}





