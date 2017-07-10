/**
132. Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Solution: DP, be careful about the way of calculating Palindrome.
*/

public class Solution {
    private boolean[][] getPalindrome(String s) {
        int len = s.length(); 
        boolean[][] isPalindrome = new boolean[len][len]; 
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true; 
        }
        for (int i = 0; i < len - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)); 
        }
        for (int length = 2; length < len; length++) {
            for (int start = 0; start < len - length; start++) {
                isPalindrome[start][start + length] = (isPalindrome[start + 1][start + length - 1]) && (s.charAt(start) == s.charAt(start + length)); 
            }
        }
        return isPalindrome; 
    }
    
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        boolean[][] isPalindrome = getPalindrome(s); 
        int[] min = new int[s.length()]; 
        min[0] = 0; 
        for (int i = 1; i < s.length(); i++) {
            min[i] = Integer.MAX_VALUE; 
            for (int j = 0; j < i; j++) {
                if (j == 0 && isPalindrome[j][i]) {
                    min[i] = 0; 
                    break; 
                }
                if (min[j] != Integer.MAX_VALUE && isPalindrome[j + 1][i]) {
                    min[i] = Math.min(min[i], min[j] + 1); 
                }
            }
        }
        return min[s.length() - 1]; 
    }
}