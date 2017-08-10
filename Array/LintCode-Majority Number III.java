/**
LintCode: Majority Number III

Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

Find it.

 Notice

There is only one majority number in the array.

Have you met this question in a real interview? Yes
Example
Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

Challenge 
O(n) time and O(k) extra space

Solution: Similar to Majority Number II, use hashmap to perform like candidates. 
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1); 
            } else if (map.size() < k - 1) {
                map.put(num, 1); 
            } else {
                List<Integer> keys = new ArrayList<>(); 
                for (Integer key : map.keySet()) {
                    map.put(key, map.get(key) - 1); 
                    if (map.get(key) == 0) {
                        keys.add(key); 
                    }
                }
                for (Integer key : keys) {
                    map.remove(key); 
                }
            }
        }
        
        for (Integer key : map.keySet()) {
            map.put(key, 0); 
        }
        
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1); 
            }
        }
        
        int res = 0; 
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.size() / k) {
                res = key; 
                break; 
            }
        }
        return res; 
    }
}
