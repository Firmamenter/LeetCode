/**
168. Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

Solution: Math.
*/

public class Solution {
    public String convertToTitle(int n) {
        String res = new String(); 
        while (n != 0) {
            int temp = n % 26; 
            if (temp == 0) {
                res = 'Z' + res + ""; 
            } else {
                res = (char)('A' + temp - 1) + res + ""; 
            }
            n = (n - 1) / 26; 
        }
        return res; 
    }
}