/**
405. Convert a Number to Hexadecimal

Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"

Solution: Math.
*/

public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0"; 
        }
        if (num < 0) {
            long temp = 0x00000000ffffffffL & num; 
            return helper(temp); 
        }
        return helper((long)num); 
    }
    
    private String helper(long num) {
        StringBuilder res = new StringBuilder(); 
        while (num > 0) {
            long mod = num % 16; 
            if (mod < 10) {
                res.append(mod); 
            } else {
                res.append((char)('a' + (int)mod - 10)); 
            }
            num /= 16; 
        }
        return res.reverse().toString(); 
    }
}