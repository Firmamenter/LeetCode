/**
171. Excel Sheet Column Number

Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

Solution: Base conversion.
*/

public class Solution {
    public int titleToNumber(String s) {
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('A' > s.charAt(i) || s.charAt(i) > 'Z') {
                return 0;
            } else {
                result = s.charAt(i) - 'A' + 1 + result * 26;
            }
        }
        return result; 
    }
}