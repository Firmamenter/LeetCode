/**
LintCode: Longest Common Subsequence

Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

Have you met this question in a real interview? Yes
Clarification
What's the definition of Longest Common Subsequence?

https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
http://baike.baidu.com/view/2020307.htm
Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

For "ABCD" and "EACB", the LCS is "AC", return 2.

Solution: DP.
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0; 
        }
        
        int[][] res = new int[A.length()][B.length()]; 
        res[0][0] = (A.charAt(0) == B.charAt(0)) ? 1 : 0; 
        for (int i = 1; i < B.length(); i++) {
            if (A.charAt(0) == B.charAt(i)) {
                res[0][i] = 1; 
            } else {
                res[0][i] = res[0][i - 1]; 
            }
        }
        for (int j = 1; j < A.length(); j++) {
            if (A.charAt(j) == B.charAt(0)) {
                res[j][0] = 1; 
            } else {
                res[j][0] = res[j - 1][0]; 
            }
        }
        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    res[i][j] = res[i - 1][j - 1] + 1; 
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]); 
                }
            }
        }
        return res[A.length() - 1][B.length() - 1]; 
    }
}
