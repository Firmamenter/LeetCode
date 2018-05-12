/**
49. Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

Solution: Use Map<String, List<String>> to group anagrams together. 
*/

// Time: O(nklogk)
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>(); 
        if (strs == null || strs.length == 0) {
            return res; 
        }
        
        Map<String, List<String>> map = new HashMap<>(); 
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray(); 
            Arrays.sort(temp); 
            String s = Arrays.toString(temp); // String s = String.valueOf(temp); 
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]); 
            } else {
                List<String> list = new ArrayList<>(); 
                list.add(strs[i]); 
                map.put(s, list); 
            }
        }
        
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            res.add(e.getValue()); 
        }
        
        return res; 
    }
}