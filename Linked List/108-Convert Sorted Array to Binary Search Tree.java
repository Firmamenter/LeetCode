/**
108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

Solution: Divide & Conquer. O(n).
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    private TreeNode convert2Tree(int[] A, int s, int e) {
        if (s < e) {
            int mid = s + (e - s) / 2; 
            TreeNode root = new TreeNode(A[mid]); 
            root.left = convert2Tree(A, s, mid - 1); 
            root.right = convert2Tree(A, mid + 1, e); 
            return root; 
        } else if (s == e) {
            return new TreeNode(A[s]); 
        } else {
            return null; 
        }
    }
    
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if (A == null || A.length == 0) {
            return null; 
        }
        
        TreeNode root = new TreeNode(A[(A.length - 1) / 2]); 
        root.left = convert2Tree(A, 0, (A.length - 1) / 2 - 1); 
        root.right = convert2Tree(A, (A.length - 1) / 2 + 1, A.length - 1); 
        
        return root; 
    }  
}
