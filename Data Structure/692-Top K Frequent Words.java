/**
692. Top K Frequent Words

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.

Solution: 1) Collections.sort() O(nlogn) 2) Min heap O(nlogk)
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()); 
        Map<String, Integer> map = new HashMap<>(); 
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1); 
        }
        for (Map.Entry entry : map.entrySet()) {
            minHeap.offer(entry); 
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        List<String> res = new ArrayList<>(); 
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey()); 
        }
        Collections.reverse(res); 
        return res; 
    }
}