/**
LintCode: Sqrt(x) II

Implement double sqrt(double x) and x >= 0.

Compute and return the square root of x.

Sol: BS. Be careful about accuracy. 浮点不要用==而是差值小于精度去比较. 一般eps设置比精度小几个数量级, 本题要求1e-8, 我们设置1e-12.
*/

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        if (x == 0 || x == 1) {
        	return x; 
        }
        double left = 0; 
        double right = Math.max(x, 1.0); 
        while (left + 1e-12 < right) {
        	double mid = left + (right - left) / 2.0; 
        	if (mid * mid - x < 1e-12) {
        		return mid; 
        	} else if (mid * mid < x) {
        		left = mid; 
        	} else {
        		right = mid; 
        	}
        }
        if (right * right - x < 1e-12) {
        	return right; 
        } else {
        	return left; 
        }
    }
}