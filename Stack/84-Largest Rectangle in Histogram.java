/**
84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

Solution: Using stack. Iterate from left to right, whenever find a element smaller than the previous one, pop it and calculate the area.
*/
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0; 
        }
        
        int index = 0; 
        int maxRec = 0; 
        Stack<Integer> stack = new Stack<>(); 
        stack.push(0); 
        maxRec = heights[0]; 
        
        for (int i = 1; i < heights.length; i++) {
            if (heights[stack.peek()] <= heights[i]) {
                stack.push(i); 
            } else {
                while (stack.size() > 1 && heights[stack.peek()] > heights[i]) {
                    index = stack.pop(); 
                    maxRec = Math.max(maxRec, heights[index] * (i - stack.peek() - 1)); 
                }
                if (stack.size() == 1 && heights[stack.peek()] > heights[i]) {
                    index = stack.pop(); 
                    maxRec = Math.max(maxRec, heights[index] * i); 
                }
                stack.push(i); 
            }
        }
        
        while (!stack.empty()) {
            index = stack.pop(); 
            while (!stack.empty() && heights[stack.peek()] == heights[index]) {
                stack.pop(); 
            }
            if (!stack.empty()) {
                maxRec = Math.max(maxRec, heights[index] * (heights.length - stack.peek() - 1)); 
            } else {
                maxRec = Math.max(maxRec, heights[index] * heights.length); 
            }
        }
        
        return maxRec; 
    }
}