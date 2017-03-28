/**
58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

Solution: strName.lastIndexOf(" ")
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        s = s.trim(); 
        if (s.length() == 0) {
            return 0; 
        } else {
            return s.length() - s.lastIndexOf(" ") - 1; 
        }
    }
}