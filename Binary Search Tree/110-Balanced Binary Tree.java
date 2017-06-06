/**
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Solution: Little modifications from Maximum Depth Binary Tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return findMaxDepth(root) != -1; 
    }
    
    private int findMaxDepth(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        
        int left = findMaxDepth(root.left); 
        int right = findMaxDepth(root.right); 
        
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1; 
        } else {
            return Math.max(left, right) + 1; 
        }
    }
}