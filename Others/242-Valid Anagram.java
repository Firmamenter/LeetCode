/**
242. Valid Anagram

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

Solution: 26 English letters.
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true; 
        } else if (s == null) {
            return false; 
        } else if (t == null) {
            return false; 
        } else if (s.length() != t.length()) {
            return false; 
        }
        
        int[] count = new int[26]; 
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; 
            count[t.charAt(i) - 'a']--; 
        }
        for (int j = 0; j < count.length; j++) {
            if (count[j] != 0) {
                return false; 
            }
        }
        return true; 
    }
}