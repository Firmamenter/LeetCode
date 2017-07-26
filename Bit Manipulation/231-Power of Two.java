/**
231. Power of Two

Given an integer, write a function to determine if it is a power of two.

Solution: Bit Manipulation. 
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false; 
        }
        int count = 0; 
        while (n != 0) {
            count += n & 1; 
            n >>>= 1; 
        }
        return count == 1; 
    }
}