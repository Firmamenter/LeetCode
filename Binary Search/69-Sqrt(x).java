/**
69. Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x.

Solution: BS, but be careful about overflow.
*/

public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1; 
        }
        long start = 0; 
        long end = x; 
        long mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (mid * mid == x) {
                return (int)mid; 
            } else if (mid * mid < x) {
                start = mid; 
            } else {
                end = mid; 
            }
        }
        if (end * end == x) {
            return (int)end; 
        } else {
            return (int)start; 
        }
    }
}