/**
347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ? k ? number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

Solution: MinHeap. 
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1); 
            } else {
                map.put(nums[i], map.get(nums[i]) + 1); 
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue()); 
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry); 
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        List<Integer> res = new ArrayList<>(); 
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey()); 
        }
        Collections.reverse(res); 
        return res; 
    }
}