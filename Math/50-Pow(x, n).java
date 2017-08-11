/**
50. Pow(x, n)

Implement pow(x, n).

Solution: Divide and Conquer. Be careful about stack overflow when dealing with minus numbers. 
*/

public class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0 || n == 0) {
            return 1.0; 
        }
        
        if (n < 0) {
            return 1 / (myPow(x, -1 * (n / 2)) * myPow(x, -1 * (n - n / 2))); 
        }
        
        // Divide 
        double half = myPow(x, n / 2); 
        if (n % 2 == 0) {
            return half * half; 
        } else {
            return half * half * x; 
        }
    }
}