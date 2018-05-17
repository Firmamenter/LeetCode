/**
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

Solution: DP. Time O(n^2) Space O(n^2)
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null; 
        }
        int len = s.length(); 
        if (len == 0 || len == 1) {
            return s; 
        }
        String substring = ""; 
        boolean[][] isPalindrome = new boolean[len][len]; 
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true; 
            substring = s.charAt(i) + ""; 
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (j == i + 1) {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j); 
                } else {
                    if (s.charAt(i) != s.charAt(j)) {
                        isPalindrome[i][j] = false; 
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1]; 
                    }
                }
                if (isPalindrome[i][j] && j - i + 1 >= substring.length()) {
                    substring = s.substring(i, j + 1); 
                }
            }
        }
        return substring; 
    }
}