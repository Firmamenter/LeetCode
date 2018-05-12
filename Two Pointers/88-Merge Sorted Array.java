/**
88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Solution: 1) Use extra space, two pointer. 2) Compare from end to start without extra space, use two pointer.
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m]; 
        int i; 
        for (i = 0; i < m; i++) {
            temp[i] = nums1[i]; 
        }
        int count = 0; 
        int j = 0; 
        i = 0;
        while ((i < m) && (j < n)) {
            if (temp[i] <= nums2[j]) {
                nums1[count++] = temp[i++]; 
            } else {
                nums1[count++] = nums2[j++]; 
            }
        }
        while (i < m) {
            nums1[count++] = temp[i++]; 
        }
        while (j < n) {
            nums1[count++] = nums2[j++]; 
        }
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m != 0 && n != 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1]; 
                m--; 
            } else {
                nums1[m + n - 1] = nums2[n - 1]; 
                n--;
            }
        }
        while (n != 0) {
            nums1[n - 1] = nums2[n - 1]; 
            n--; 
        }
    }
}