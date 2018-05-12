/**
50. Pow(x, n)

Implement pow(x, n).

Solution: Fast Power Algorithm. 
*/

// Time: O(logn), Space: O(logn)
class Solution {
    public double myPow(double x, int n) {
        long nn = n; 
        if (nn < 0) {
            x = 1.0 / x; 
            nn *= -1; 
        }
        return helper(x, nn); 
    }
    
    private double helper(double x, int n) {
        if (x == 1 || n == 0) {
            return 1; 
        }
        double half = helper(x, n / 2); 
        if (n % 2 == 0) {
            return half * half; 
        } else {
            return half * half * x; 
        }
    }
}

// Time: O(logn), Space: O(1)
class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1.0; 
        }
        long nn = n; 
        if (nn < 0) {
            x = 1.0 / x; 
            nn *= -1; 
        }
        double res = 1; 
        double cur = x; 
        while (nn > 0) {
            if (nn % 2 == 1) {
                res *= cur; 
            }
            cur *= cur; 
            nn /= 2; 
        }
        return res; 
    }
}