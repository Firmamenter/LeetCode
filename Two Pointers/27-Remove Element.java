/**
27. Remove Element

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Sol: two pointer.
*/
public class Solution {
  public int removeElement(int[] nums, int val) {
        int left = 0; 
        int right = nums.length - 1; 
        while (left <= right) {
            if (nums[right] == val) {
                right--;
            } else if (nums[left] == val) {
                int temp = nums[right]; 
                nums[right] = nums[left]; 
                nums[left] = temp; 
                right--; 
                left++; 
            } else {
                left++; 
            }
        }
        return left; 
    }
}

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        int left = 0; 
        int right = 0; 
        for (; right < nums.length; right++) {
            if (nums[right] != val && nums[left] != val) {
                left++; 
            } else if (nums[right] != val && nums[left] == val) {
                int temp = nums[right]; 
                nums[right] = nums[left]; 
                nums[left] = temp; 
                left++; 
            }
        }
        return left; 
    }
}

public int removeElement(int[] A, int elem) {
   int m = 0;    
   for(int i = 0; i < A.length; i++){
       
       if(A[i] != elem){
           A[m] = A[i];
           m++;
       }
   }
   
   return m;
}