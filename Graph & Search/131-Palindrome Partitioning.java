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