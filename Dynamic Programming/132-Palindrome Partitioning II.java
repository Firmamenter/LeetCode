/**
132. Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Solution: DP, be careful about the way of calculating Palindrome.
*/

public class Solution {
    private boolean[][] getPalindrome (String s) {
        boolean[][] res = new boolean[s.length()][s.length()]; 
        for (int i = 0; i < s.length(); i++) {
            res[i][i] = true; 
        }
        for (int i = 0; i < s.length() - 1; i++) {
            res[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)); 
        }
        for (int len = 2; len < s.length(); len++) {
            for (int start = 0; start + len < s.length(); start++) {
                res[start][len] = (res[start + 1][len - 1]) && (s.charAt(start) == s.charAt(start + len)); 
            }
        }
        
        return res; 
    }
    
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        boolean[][] isPalindrome = getPalindrome(s);  
        
        int[] min = new int[s.length() + 1]; 
        min[0] = 0; 
        for (int i = 1; i <= s.length(); i++) {
            min[i] = Integer.MAX_VALUE; 
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    min[i] = Math.min(min[i], min[j] + 1); 
                }
            }
        }
        
        return min[s.length()] - 1; 
    }
}