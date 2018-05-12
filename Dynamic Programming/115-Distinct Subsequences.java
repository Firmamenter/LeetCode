/**
115. Distinct Subsequences

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

Solution: DP. If s.charAt(i - 1) != t.charAt(j - 1), then we shall not use (i - 1)th character to get the target subsequence, thus dp[i][j] = dp[i - 1][j]; 
          if s.charAt(i - 1) == t.charAt(j - 1), then we can choose whether use the (i - 1)th character in s or not, so dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]. 
*/

public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return 0; 
        if (s.equals(t) || t.length() == 0) return 1; 
        int[][] dp = new int[s.length()][t.length()]; 
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0; 
        for (int i = 1; i < s.length(); i++) dp[i][0] = s.charAt(i) == t.charAt(0) ? dp[i - 1][0] + 1 : dp[i - 1][0]; 
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j <= Math.min(i, t.length() - 1); j++) {
                dp[i][j] = dp[i - 1][j]; 
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i - 1][j - 1]; 
                }
            }
        }
        return dp[s.length() - 1][t.length() - 1]; 
    }
}

// Use only one row for dp. 
public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return 0; 
        if (s.equals(t) || t.length() == 0) return 1; 
        int[] dp = new int[t.length()]; 
        dp[0] = s.charAt(0) == t.charAt(0) ? 1 : 0; 
        for (int i = 1; i < s.length(); i++) {
            for (int j = Math.min(i, t.length() - 1); j >= 0; j--) {
                if (j == 0) dp[0] = s.charAt(i) == t.charAt(0) ? dp[0] + 1 : dp[0]; 
                if (j > 0 && s.charAt(i) == t.charAt(j)) {
                    dp[j] += dp[j - 1]; 
                }
            }
        }
        return dp[t.length() - 1]; 
    }
}