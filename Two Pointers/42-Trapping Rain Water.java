/**
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Solution: Two pointers. 
*/
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0; 
        }
        
        int left = 0; 
        int right = height.length - 1; 
        while (left < right) {
            if (height[left] > height[++left]) {
                break; 
            }
        }
        left--; 
        while (left < right) {
            if (height[right] > height[--right]) {
                break; 
            }
        }
        right++; 
        
        int area = 0; 
        while (left < right) {
            if (height[left] < height[right]) {
                int leftH = height[left++]; 
                while (height[left] < leftH) {
                    area += leftH - height[left++]; 
                }
            } else {
                int rightH = height[right--]; 
                while (height[right] < rightH) {
                    area += rightH - height[right--]; 
                }
            }
        }
        return area; 
    }
}