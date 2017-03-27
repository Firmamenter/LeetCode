/**
7. Reverse Integer

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

Solution: Mod operation. Be careful, in Java, -5%2 = -1! Integer.MAX_VALUE, Integer.MIN_VALUE.
*/

public class Solution {
    public int reverse(int x) {
        long res = 0; 
        while (x != 0) {
            res = res * 10 + x % 10; 
            x /= 10; 
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0; 
        } else {
            return (int)res; 
        } 
    }
}