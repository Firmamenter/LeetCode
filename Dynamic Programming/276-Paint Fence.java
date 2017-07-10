/**
276. Paint Fence

There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.

 Notice

n and k are non-negative integers.

Example
Given n=3, k=2 return 6

      post 1,   post 2, post 3
way1    0         0       1 
way2    0         1       0
way3    0         1       1
way4    1         0       0
way5    1         0       1
way6    1         1       0

Solution: DP. Save memory if you only use several states.
*/

public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        int[] paint = {0, k, k*k, 0}; 
        if (n <= 2) {
            return paint[n]; 
        }
        
        for (int i = 3; i <= n; i++) {
            paint[3] = (k - 1) * (paint[1] + paint[2]); 
            paint[1] = paint[2]; 
            paint[2] = paint[3]; 
        }
        
        return paint[3]; 
    }
}