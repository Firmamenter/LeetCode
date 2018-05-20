/**
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

Solution: BS
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0) {
            return 0; 
        }
        int length = nums1.length + nums2.length; 
        if (length % 2 == 0) {
            return (findKthElement(nums1, nums2, length / 2, 0, 0) + findKthElement(nums1, nums2, length / 2 + 1, 0, 0)) / 2.0; 
        } else {
            return findKthElement(nums1, nums2, length / 2 + 1, 0, 0); 
        }
    }
    
    public double findKthElement(int[] A, int[] B, int k, int startA, int startB) {
        if (startA >= A.length) {
            return B[startB + k - 1]; 
        }
        if (startB >= B.length) {
            return A[startA + k - 1]; 
        }
        
        if (k == 1) {
            return A[startA] > B[startB] ? B[startB] : A[startA]; 
        }
        
        int keyA = k / 2 - 1 + startA < A.length ? A[k / 2 - 1 + startA] : Integer.MAX_VALUE; 
        int keyB = k / 2 - 1 + startB < B.length ? B[k / 2 - 1 + startB] : Integer.MAX_VALUE; 
        
        if (keyA < keyB) {
            return findKthElement(A, B, k - k / 2, startA + k / 2, startB);
        } else {
            return findKthElement(A, B, k - k / 2, startA, startB + k / 2);    
        }
    }
}


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0) {
            return 0; 
        }
        int length = nums1.length + nums2.length; 
        if (length % 2 == 0) {
            return (findKthElement(nums1, nums2, length / 2, 0, 0) + findKthElement(nums1, nums2, length / 2 + 1, 0, 0)) / 2.0; 
        } else {
            return findKthElement(nums1, nums2, length / 2 + 1, 0, 0); 
        }
    }
    
    public double findKthElement(int[] A, int[] B, int k, int startA, int startB) {
        if (k == 1) {
            if (startA >= A.length) {
                return B[startB]; 
            }
            if (startB >= B.length) {
                return A[startA]; 
            }
            return A[startA] > B[startB] ? B[startB] : A[startA]; 
        }
        
        int keyA = k / 2 - 1 + startA < A.length ? A[k / 2 - 1 + startA] : Integer.MAX_VALUE; 
        int keyB = k / 2 - 1 + startB < B.length ? B[k / 2 - 1 + startB] : Integer.MAX_VALUE; 
        
        if (keyA < keyB) {
            return findKthElement(A, B, k - k / 2, startA + k / 2, startB);
        } else {
            return findKthElement(A, B, k - k / 2, startA, startB + k / 2);    
        }
    }
}