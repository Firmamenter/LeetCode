/**
326. Power of Three 

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

Solution: Use Log10. 
*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false; 
        }
        double res = Math.log10(n) / Math.log10(3); 
        return res - (int)res == 0; 
    }
}