/**
131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

Solution: Similar to subsets and permutation problems. The most important thing is to build the constructive tree.
*/
// Use function to check palindrome. 
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>(); 
        if (s == null || s.length() == 0) {
            return res; 
        }
        List<String> list = new ArrayList<>(); 
        helper(res, s, list, 0); 
        return res; 
    }
    
    private void helper(List<List<String>> res, String s, List<String> list, int position) {
        if (position == s.length()) {
            res.add(new ArrayList<String>(list)); 
            return; 
        }
        
        for (int i = position; i < s.length(); i++) {
            if (isPalindrome(s.substring(position, i + 1))) {
                list.add(s.substring(position, i + 1)); 
                helper(res, s, list, i + 1); 
                list.remove(list.size() - 1); 
            }
        }
    }
    
    private boolean isPalindrome(String substring) {
        int left = 0; 
        int right = substring.length() - 1; 
        while (left < right) {
            if (substring.charAt(left) != substring.charAt(right)) {
                return false; 
            }
            left++; 
            right--; 
        }
        return true; 
    }
}

// Use boolean[][] to store information about palindrome.
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>(); 
        if (s == null || s.length() == 0) {
            return res; 
        }
        int len = s.length(); 
        boolean[][] isPalindrome = new boolean[len][len]; 
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true; 
        }
        for (int start = len - 2; start >= 0; start--) {
            for (int end = start + 1; end < len; end++) {
                if (s.charAt(start) == s.charAt(end) && 
                    (start + 1 == end || (start + 1 < end && isPalindrome[start + 1][end - 1]))) {
                    isPalindrome[start][end] = true; 
                }
            }
        }
        helper(s, res, isPalindrome, 0, new ArrayList<String>()); 
        return res; 
    }
    
    private void helper(String s, List<List<String>> res, boolean[][] isPalindrome, int pos, List<String> list) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(list)); 
            return; 
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome[pos][i]) {
                list.add(s.substring(pos, i + 1)); 
                helper(s, res, isPalindrome, i + 1, list); 
                list.remove(list.size() - 1); 
            }
        }
    }
}