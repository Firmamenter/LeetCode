/**
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Solution: HashMap. 
*/

// Time: O(n)    Space: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        Map<Character, Integer> map = new HashMap<>(); 
        int idx = 0; 
        int res = 0; 
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                idx = Math.max(idx, map.get(s.charAt(i)) + 1); 
            }
            res = Math.max(res, i - idx + 1); 
            map.put(s.charAt(i), i); 
        }
        return res; 
    }
}