/**
105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

Solution: Recursion.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1); 
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) return null; 
        TreeNode root = new TreeNode(preorder[preStart]); 
        int idx = inStart; 
        for (; idx <= inEnd; idx++) {
            if (inorder[idx] == preorder[preStart]) break; 
        }
        root.left = helper(preorder, inorder, preStart + 1, inStart, idx - 1); 
        root.right = helper(preorder, inorder, preStart + idx - inStart + 1, idx + 1, inEnd); 
        return root; 
    }
}