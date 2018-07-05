/**
340. Longest Substring with At Most K Distinct Characters

Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

Sol: Two pointers.
*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0; 
        }
        Map<Character, Integer> map = new HashMap<>(); 
        int left = 0, right = 0, maxLen = 0; 
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1); 
                right++; 
            } else if (map.size() < k) {
                map.put(s.charAt(right), 1); 
                right++; 
            } else {
                if (map.get(s.charAt(left)) == 1) {
                    map.remove(s.charAt(left)); 
                } else {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1); 
                }
                left++; 
            }
            maxLen = Math.max(maxLen, right - left); 
        }
        return maxLen; 
    }
}