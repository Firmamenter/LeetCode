/**
76. Minimum Window Substring

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

Sol: Two pointers + Hashmap. 
*/

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return ""; 
        }
        
        Map<Character, Integer> mapT = new HashMap<>(); 
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1); 
        }
        
        int left = 0, right = 0; 
        boolean flag = false; 
        String res = s; 
        Map<Character, Integer> map = new HashMap<>(); 
        while (right <= s.length()) {
            if (isValid(map, mapT)) {
                flag = true; 
                res = res.length() > right - left ? s.substring(left, right) : res; 
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) == 1) {
                        map.remove(s.charAt(left)); 
                    } else {
                        map.put(s.charAt(left), map.get(s.charAt(left)) - 1); 
                    }
                }
                left++; 
            } else {
                if (right == s.length()) {
                    break; 
                }
                if (mapT.containsKey(s.charAt(right))) {
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1); 
                }
                right++; 
            }
        }
        
        return flag ? res : ""; 
    }
    
    private boolean isValid(Map<Character, Integer> map, Map<Character, Integer> mapT) {
        for (Character c : mapT.keySet()) {
            if (!map.containsKey(c) || map.get(c) < mapT.get(c)) {
                return false; 
            }
        }
        return true; 
    }
}