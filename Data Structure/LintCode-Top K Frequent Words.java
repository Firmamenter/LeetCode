/**
LintCode: Top K Frequent Words

Given a list of words and an integer k, return the top k frequent words in the list.

 Notice

You should order the words by the frequency of them in the return list, the most frequent one comes first. If two words has the same frequency, the one with lower alphabetical order come first.

Example
Given

[
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
]
for k = 3, return ["code", "lint", "baby"].

for k = 4, return ["code", "lint", "baby", "yes"],

Solution: 1) Use merely hashmap and Collections.sort(), you have to first metamorphase map into List<Map.Entry<>>, then implement a Comparator.
             O(nlogn)
          2) Use hashmap and heap.
*/

//O(nlogk)
public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null) {
            return null; 
        } else if (k == 0 || words.length == 0) {
            return new String[0]; 
        }
        
        Map<String, Integer> count = new HashMap<>(); 
        for (int i = 0; i < words.length; i++) {
            if (!count.containsKey(words[i])) {
                count.put(words[i], 1); 
            } else {
                count.put(words[i], count.get(words[i]) + 1); 
            }
        }
        
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return (a.getValue() == b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue(); 
            }
        }); 
        
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            minHeap.offer(e); 
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        
        int size = Math.min(k, minHeap.size()); 
        String[] res = new String[size]; 
        for (int j = size - 1; j >= 0; j--) {
            res[j] = minHeap.poll().getKey(); 
        }
        
        return res; 
    }
}

//O(nlogn)
public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null) {
            return null; 
        }
        
        Map<String, Integer> count = new HashMap<>(); 
        
        for (int i = 0; i < words.length; i++) {
            if (!count.containsKey(words[i])) {
                count.put(words[i], 1); 
            } else {
                count.put(words[i], count.get(words[i]) + 1); 
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet()); 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return (b.getValue() == a.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue(); 
            }
        }); 
        
        int size = (k > list.size()) ? list.size() : k; 
        String[] res = new String[size]; 
        for (int j = 0; j < size; j++) {
            res[j] = list.get(j).getKey(); 
        }
        
        return res; 
    }
}