/**
647. Palindromic Substrings

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.

Solution: DP. 
*/
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0; 
        int count = 0; 
        boolean[][] isPalindrome = new boolean[s.length()][s.length()]; 
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true; 
            count++; 
        }
        for (int start = s.length() - 2; start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) != s.charAt(end)) continue; 
                if (start + 1 == end || isPalindrome[start + 1][end - 1]) {
                    isPalindrome[start][end] = true; 
                    count++; 
                }
            }
        }
        return count; 
    }
}