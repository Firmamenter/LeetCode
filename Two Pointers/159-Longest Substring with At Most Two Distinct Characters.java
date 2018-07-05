/**
159. Longest Substring with At Most Two Distinct Characters

Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.

Sol: Two Pointers. 
*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        int maxLen = 0; 
        int left = 0; 
        int right = 0; 
        Map<Character, Integer> map = new HashMap<>(); 
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1); 
                right++; 
            } else if (map.size() < 2) {
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