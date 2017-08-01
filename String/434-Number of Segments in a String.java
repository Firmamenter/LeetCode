/**
434. Number of Segments in a String

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5

Solution: String. 
*/

public class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }
        int count = 0; 
        s = s.trim(); 
        if (s.length() == 0) {
            return 0; 
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                count++; 
            }
        }
        return count + 1; 
    }
}