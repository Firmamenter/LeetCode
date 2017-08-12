/**
LintCode: Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Trapping Rain Water

Have you met this question in a real interview? Yes
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge 
O(n) time and O(1) memory

O(n) time and O(n) memory is also acceptable.

Solution: Two pointer. 
*/

public class Solution {
    /*
     * @param : a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 3) {
            return 0; 
        }
        
        int left = 0; 
        int right = heights.length - 1; 
        
        // Find the highest bar from left. 
        while (left < right) {
            if (heights[left] > heights[++left]) {
                break; 
            }
        }
        left--; 
        // Find the highest bar from right. 
        while (left < right) {
            if (heights[right] > heights[--right]) {
                break; 
            }
        }
        right++; 
        
        // Calculate the area. 
        int area = 0; 
        while (left < right) {
            if (heights[left] < heights[right]) {
                int leftHeight = heights[left++]; 
                while (heights[left] < leftHeight) {
                    area += leftHeight - heights[left++]; 
                }
            } else {
                int rightHeight = heights[right--]; 
                while (heights[right] < rightHeight) {
                    area += rightHeight - heights[right--]; 
                }
            }
        }
        return area; 
    }
};