/**
367. Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False

Solution: Binary Search. 
*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false; 
        }
        long start = 0; 
        long end = (long)num; 
        long mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (mid * mid == (long)num) {
                return true; 
            } else if (mid * mid < (long)num) {
                start = mid; 
            } else {
                end = mid; 
            }
        }
        if (start * start == (long)num) {
            return true; 
        } else if (end * end == (long)num) {
            return true; 
        } else {
            return false; 
        }
    }
}