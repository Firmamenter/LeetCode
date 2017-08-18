/**
357. Count Numbers with Unique Digits

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Solution: Math. O(1). 
*/

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n >= 10) {
            return 0; 
        }
        if (n == 0) {
            return 1; 
        }
        if (n == 1) {
            return 10; 
        }
        int sum = 91; 
        int cur = 81; 
        for (int i = 3; i <= n; i++) {
            cur *= (10 - i + 1); 
            sum += cur; 
        }
        return sum; 
    }
}