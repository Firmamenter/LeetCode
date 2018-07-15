/**
LintCode: Wood Cut

Description
Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
You couldn't cut wood into float length.
If you couldn't get >= k pieces, return 0.
Have you met this question in a real interview?  Yes
Example
For L=[232, 124, 456], k=7, return 114.
Challenge
O(n log Len), where Len is the longest length of the wood.

Sol: BS. 
*/

public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0; 
        }
        int start = 1; 
        int end = Integer.MIN_VALUE; 
        for (int l : L) {
            end = Math.max(l, end); 
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; 
            if (checkNum(mid, L) < k) {
                end = mid; 
            } else {
                start = mid; 
            }
        }
        if (checkNum(end, L) >= k) {
            return end; 
        } else if (checkNum(start, L) >= k) {
            return start; 
        } else {
            return 0; 
        }
    }
    
    private int checkNum(int len, int[] L) {
        int num = 0; 
        for (int l : L) {
            num += l / len; 
        }
        return num; 
    }
}