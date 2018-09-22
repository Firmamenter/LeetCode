/**
551. Student Attendance Record I

You are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False

Solution: String. 
*/
class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return false; 
        }
        if (s.length() == 1) {
            return true; 
        }
        int cntA = 0, cntL = 0, maxLen = 0; 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                cntA++; 
            }
            if (s.charAt(i) == 'L') {
                cntL++; 
                maxLen = Math.max(maxLen, cntL); 
            } else {
                cntL = 0; 
            }
        }
        return (maxLen <= 2) && (cntA <= 1); 
    }
}

public class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return false; 
        } else if (s.length() < 2) {
            return true; 
        }
        int count = 0; 
        int left = -1; 
        int len = 0; 
        int right = 0; 
        for (; right < s.length(); right++) {
            if (s.charAt(right) == 'A') {
                count++; 
            }
            if (s.charAt(right) != 'L') {
                len = Math.max(len, right - left - 1); 
                left = right; 
            }
        }
        if (left + 1 < right) {
            len = Math.max(len, right - left - 1); 
        }
        return (count <= 1) && (len <= 2); 
    }
}