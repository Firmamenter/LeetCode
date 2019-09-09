/**
528. Random Pick with Weight

Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

Sol: Binary search
*/

class Solution {
    private int[] weight; 
    private int[] preSum; 
    private int totalSum; 

    public Solution(int[] w) {
        if (w == null || w.length == 0) {
            return; 
        }
        int len = w.length; 
        weight = w; 
        preSum = new int[len]; 
        preSum[0] = w[0]; 
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + w[i]; 
        }
        totalSum = preSum[len - 1]; 
    }
    
    public int pickIndex() {
        int randomPoint = (int)Math.round(Math.random() * totalSum); 
        System.out.println(randomPoint); 
        int start = 0; 
        int end = preSum.length - 1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (preSum[mid] >= randomPoint) {
                mid = end; 
            } else {
                mid = start; 
            }
        }
        if (preSum[start] >= randomPoint) {
            return start; 
        } else {
            return end; 
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */