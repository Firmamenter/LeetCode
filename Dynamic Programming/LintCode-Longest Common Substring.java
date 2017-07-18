/**
LintCode: Longest Common Substring

Given two strings, find the longest common substring.

Return the length of it.

 Notice

The characters in substring should occur continuously in original string. This is different with subsequence.

Have you met this question in a real interview? Yes
Example
Given A = "ABCD", B = "CBCE", return 2.

Solution: DP.
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0; 
        }
        
        int[][] res = new int[A.length()][B.length()]; 
        res[0][0] = (A.charAt(0) == B.charAt(0)) ? 1 : 0; 
        int max = 0; 
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(0)) {
                res[i][0] = 1; 
                max = Math.max(res[i][0], max); 
            }
        }
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt(0) == B.charAt(i)) {
                res[0][i] = 1; 
                max = Math.max(res[0][i], max); 
            }
        }
        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    res[i][j] = res[i - 1][j - 1] + 1; 
                    max = Math.max(res[i][j], max); 
                }
            }
        }
        return max; 
    }
}