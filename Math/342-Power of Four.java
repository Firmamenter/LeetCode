/**
342. Power of Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Solution: Math.log10(). Bit Manipulation. 
*/

// Math.log10(). 
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false; 
        }
        double res = Math.log10(num) / Math.log10(4); 
        return res - (int)res == 0; 
    }
}

// Bit Manipulation. 
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false; 
        }
        int odd; 
        int even; 
        int count = 0; 
        while (num != 0) {
            odd = num & 1; 
            count += odd; 
            num >>>= 1; 
            even = num & 1; 
            if (even == 1) {
                return false; 
            }
            num >>>= 1; 
        }
        return count == 1; 
    }
}