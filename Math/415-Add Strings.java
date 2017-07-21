/**
415. Add Strings

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

Solution: Math.
*/

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder(); 
        int len1 = num1.length(); 
        int len2 = num2.length(); 
        int carrier = 0; 
        int i = 0; 
        for (; i < Math.min(len1, len2); i++) {
            int sum = carrier + num1.charAt(len1 - 1 - i) - '0' + num2.charAt(len2 - 1 - i) - '0'; 
            res.append(sum % 10); 
            carrier = sum / 10; 
        }
        while (i < len1) {
            int sum = carrier + num1.charAt(len1 - 1 - i) - '0'; 
            res.append(sum % 10); 
            carrier = sum / 10; 
            i++; 
        }
        while (i < len2) {
            int sum = carrier + num2.charAt(len2 - 1 - i) - '0'; 
            res.append(sum % 10); 
            carrier = sum / 10; 
            i++; 
        }
        if (carrier != 0) {
            res.append(carrier); 
        }
        return res.reverse().toString(); 
    }
}