/**
LintCode: Fast Power

Calculate the an % b where a, b and n are all 32bit integers.

Have you met this question in a real interview? Yes
Example
For 231 % 3 = 2

For 1001000 % 1000 = 0

Challenge 
O(logn)

Solution: Be careful about stack overflow. 
          (a * b) % c = ((a % c) * (b % c)) % c. 
*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0) {
            return 1 % b; 
        } else if (n == 1) {
            return a % b; 
        }
        
        long half = fastPower(a, b, n / 2); 
        half = (half * half) % b; 
        if (n % 2 == 0) {
            return (int)half; 
        } else {
            return (int)((half * (a % b)) % b); 
        }
    }
};