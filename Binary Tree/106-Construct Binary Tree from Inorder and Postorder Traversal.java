/**
106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

Sol: Recursion
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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null 
            || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null; 
        }
        return construct(inorder, 0, postorder, 0, postorder.length - 1); 
    }
    
    private TreeNode construct(int[] inorder, int inStart, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null; 
        }
        TreeNode root = new TreeNode(postorder[postEnd]); 
        int len = postEnd - postStart + 1; 
        int idx = 0; 
        int leftLen = 0; 
        for (int i = 0; i < len; i++) {
            if (inorder[inStart + i] == root.val) {
                idx = inStart + i; 
                leftLen = i; 
                break; 
            }
        }
        TreeNode left = construct(inorder, inStart, postorder, postStart, postStart + leftLen - 1); 
        TreeNode right = construct(inorder, idx + 1, postorder, postStart + leftLen, postEnd - 1); 
        root.left = left; 
        root.right = right; 
        return root; 
    }
}