/**
516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

Solution: DP. 注意因为是subsequence，所以s.charAt(i) != s.charAt(j)时不能两边都舍弃
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        int len = s.length(); 
        int[][] palindromeLen = new int[len][len]; 
        int maxLen = 1; 
        for (int i = 0; i < len; i++) {
            palindromeLen[i][i] = 1; 
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    palindromeLen[i][j] = Math.max(palindromeLen[i + 1][j], palindromeLen[i][j - 1]); 
                } else {
                    palindromeLen[i][j] = 2; 
                    if (j > i + 1) {
                        palindromeLen[i][j] += palindromeLen[i + 1][j - 1]; 
                    }
                }
                maxLen = Math.max(maxLen, palindromeLen[i][j]); 
            }
        }
        return maxLen; 
    }
}