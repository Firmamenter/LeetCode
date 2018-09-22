/**
371. Sum of Two Integers

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

Solution: Bit Manipulation. Numbers are stored in the form of complement.
两数相加，不考虑进位是a^b，进位是(a & b) << 1，因此总的是(a ^ b) + (a & b) << 1
*/

public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a; 
        } else {
            return getSum(a ^ b, (a & b) << 1); 
        }
    }
}