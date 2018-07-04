/**
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Solution: Only 5 can generate 0, just count the amount of 5 is sufficient. 
*/

public class Solution {
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0; 
        }
        int res = 0; 
        while (n != 0) { // 5的一次方有多少，5的二次方有多少，5的三次方有多少等等
            n /= 5; 
            res += n; 
        }
        return res; 
    }
}