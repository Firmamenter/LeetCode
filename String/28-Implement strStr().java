/**
28. Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Solution: strName.indexOf()
*/

// Use built-in function. 
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); 
    }
}

// Use brute-force O(mn)
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1; 
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j <= needle.length(); j++) {
                if (j == needle.length()) return i; 
                if (needle.charAt(j) != haystack.charAt(i + j)) break; 
            }
        }
        return -1; 
    }
}

// Rabin Karp算法 O(m + n)
