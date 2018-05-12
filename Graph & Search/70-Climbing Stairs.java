/**
70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Solution: Ways to get nth stair is from (n-1)th and (n-2)th stair, so the total ways is p[n] = p[n-1] + p[n-2].
*/

// Time: O(n)	Space: O(n)
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1; 
        } else if (n == 2) {
            return 2; 
        }
        int[] p = new int[n]; 
        p[0] = 1;
        p[1] = 2;
        for (int i = 2; i < n; i++) {
            p[i] = p[i - 1] + p[i - 2]; 
        }
        return p[n - 1]; 
    }
}

// Time: O(n)	Space: O(1)
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1; 
        }
        int[] dp = new int[2]; 
        dp[0] = 1; 
        dp[1] = 2; 
        for (int i = 2; i < n; i++) {
            int temp = dp[1]; 
            dp[1] += dp[0]; 
            dp[0] = temp; 
        }
        return dp[1]; 
    }
}

// Recursion (Time Limit Exceeded)
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n; 
        }
        return climbStairs(n - 1) + climbStairs(n - 2); 
    }
}