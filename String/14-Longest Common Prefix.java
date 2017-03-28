/**
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder temp = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return temp.toString(); 
        }
        int i;
        int j;
        for (i = 0; i < strs[0].length(); i++) {
            for (j = 1; j < strs.length; j++) {
                if ((i < strs[j].length()) && (strs[0].charAt(i) == strs[j].charAt(i)));
                else {
                    return temp.toString(); 
                }
            }
            temp.append(strs[0].charAt(i)); 
        }
        return temp.toString();
    }
}