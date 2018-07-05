/**
395. Longest Substring with At Least K Repeating Characters

Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

Sol: Divide and Conquer.
*/

// Divide and Conquer. Best O(nlogn) Worst O(n^2)
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        if (k <= 1) {
            return s.length(); 
        }
        return helper(s, 0, s.length() - 1, k); 
    }
    
    private int helper(String s, int start, int end, int k) {
        if (start > end) {
            return 0; 
        }
        char[] counter = new char[26]; 
        for (int i = start; i <= end; i++) {
            counter[s.charAt(i) - 'a']++; 
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0 && counter[i] < k) {
                int idx = start + s.substring(start, end + 1).indexOf((char)('a' + i)); 
                return Math.max(helper(s, start, idx - 1, k), helper(s, idx + 1, end, k)); 
            }
        }
        return end - start + 1; 
    }
}
