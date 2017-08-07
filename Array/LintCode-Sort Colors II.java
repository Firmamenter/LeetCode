/**
LintCode: Sort Colors II

Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

 Notice

You are not suppose to use the library's sort function for this problem.

k <= n

Have you met this question in a real interview? Yes
Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

Solution: Counting the amount of different numbers. 
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int[] count = new int[k]; 
        for (int i = 0; i < colors.length; i++) {
            count[colors[i] - 1] += 1; 
        }
        int j = 0; 
        for (int i = 0; i < k; i++) {
            while (count[i] > 0) {
                colors[j] = i + 1; 
                j++; 
                count[i]--; 
            }
        }
    }
}