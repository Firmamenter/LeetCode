/**
161. One Edit Distance

Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.

Sol: String iteration. Two pointer. 
*/

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1 || s.equals(t)) {
            return false; 
        }
        int sLen = s.length(); 
        int tLen = t.length(); 
        int sIdx = sLen - 1; 
        int tIdx = tLen - 1; 
        int cnt = 0; 
        while (sIdx >= 0 && tIdx >= 0) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx--; 
                tIdx--; 
            } else if (sIdx > tIdx) {
                cnt++; 
                sIdx--; 
            } else if (sIdx < tIdx) {
                cnt++; 
                tIdx--; 
            } else {
                if (cnt == 1) {
                    return false; 
                } else {
                    sIdx--; 
                    tIdx--; 
                    cnt++;  
                }
            }
        }
        if (sIdx == -1 && tIdx == -1 || sIdx == 0 && tIdx == -1 || sIdx == -1 && tIdx == 0) {
            return true; 
        } else {
            return false; 
        }
    }
}