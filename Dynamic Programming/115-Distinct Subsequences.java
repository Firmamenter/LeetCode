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
        if (s == null || t == null) {
            return 0; 
        }
        if (s.equals(t)) {
            return 1; 
        } else if (s.length() == 0) {
            return 0; 
        } else if (t.length() == 0) {
            return 1; 
        }
        
        int[][] dp = new int[s.length() + 1][t.length() + 1]; 
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1; 
        }
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0; 
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j]; 
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1]; 
                }
            }
        }
        return dp[s.length()][t.length()]; 
    }
}