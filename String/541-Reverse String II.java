/**
541. Reverse String II

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

Solution: String.
*/

public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 2 || k <= 0) {
            return s; 
        }
        String res = new String(); 
        int i = 0; 
        for (; i + 2 * k <= s.length(); i += 2 * k) {
            StringBuilder temp = new StringBuilder(s.substring(i, i + k)); 
            res += temp.reverse().toString(); 
            res += s.substring(i + k, i + 2 * k); 
        }
        if (i + k < s.length()) {
            StringBuilder temp = new StringBuilder(s.substring(i, i + k)); 
            res += temp.reverse().toString(); 
            res += s.substring(i + k, s.length()); 
        } else {
            StringBuilder temp = new StringBuilder(s.substring(i, s.length())); 
            res += temp.reverse().toString(); 
        }
        return res; 
    }
}