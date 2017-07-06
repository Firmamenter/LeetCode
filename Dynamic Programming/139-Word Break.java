/**
139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

Solution: DP. Be careful about boundary.
*/

public class Solution {
    private int findMaxLen(List<String> wordDict) {
        int max = Integer.MIN_VALUE; 
        for (String word : wordDict) {
            max = Math.max(word.length(), max); 
        }
        return max; 
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = findMaxLen(wordDict); 
        boolean[] canSegment = new boolean[s.length() + 1]; 
        canSegment[0] = true; 
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false; 
            for (int j = Math.max(i - maxLen, 0); j < i; j++) {
                String sub = s.substring(j, i);  
                if (canSegment[j] && wordDict.contains(sub)) {
                    canSegment[i] = true; 
                    break; 
                }
            }
        }
        return canSegment[s.length()]; 
    }
}