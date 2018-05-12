/**
87. Scramble String

Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Solution: Recursion, DP. 
*/
// Recursion. 
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false; 
        if (s1.equals(s2)) return true; 
        char[] charArr1 = s1.toCharArray(); 
        char[] charArr2 = s2.toCharArray(); 
        Arrays.sort(charArr1); 
        Arrays.sort(charArr2); 
        if (!Arrays.equals(charArr1, charArr2)) return false; 
        for (int i = 0; i < s1.length() - 1; i++) {
            if (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1)) 
                && isScramble(s1.substring(i + 1), s2.substring(i + 1))) return true; 
            if (isScramble(s1.substring(0, i + 1), s2.substring(s2.length() - i - 1)) 
                && isScramble(s1.substring(i + 1), s2.substring(0, s1.length() - i - 1))) return true; 
        }
        return false; 
    }
}

// DP. 
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false; 
        if (s1.equals(s2)) return true; 
        char[] charArr1 = s1.toCharArray(); 
        char[] charArr2 = s2.toCharArray(); 
        Arrays.sort(charArr1); 
        Arrays.sort(charArr2); 
        if (!Arrays.equals(charArr1, charArr2)) return false; 
        
        int len = s1.length(); 
        boolean[][][] dp = new boolean[len][len][len + 1]; 
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j); 
            }
        }
        
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                for (int j = 0; j < len - l + 1; j++) {
                    for (int k = 1; k < l; k++) {
                        dp[i][j][l] = dp[i][j][l] || dp[i][j][k] && dp[i + k][j + k][l - k] 
                            || dp[i][j + l - k][k] && dp[i + k][j][l - k]; 
                    }
                }
            }
        }
        return dp[0][0][s1.length()]; 
    }
}