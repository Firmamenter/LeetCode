/**
501. Find Mode in Binary Search Tree

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

Solution: Whenever you are encountered with a BST, you shall remember to use Inorder Traversal.
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
    private int modeAmount = 1; 
    private int pre; 
    private int cur; 
    private int maxCount = 0; 
    private int curCount = 0; 
    
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0]; 
        }
        pre = root.val; 
        helper(root); 
        int[] res = new int[modeAmount]; 
        pre = root.val; 
        modeAmount = 0; 
        curCount = 0; 
        helper(root, res); 
        return res; 
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return; 
        }
        
        helper(root.left); 
        
        cur = root.val; 
        if (cur == pre) {
            curCount++; 
        } else {
            pre = cur; 
            curCount = 1; 
        }
        if (curCount == maxCount) {
            modeAmount++; 
        } else if (curCount > maxCount) {
            maxCount = curCount; 
            modeAmount = 1; 
        }
        
        helper(root.right); 
    }
    
    private void helper(TreeNode root, int[] res) {
        if (root == null) {
            return; 
        }
        
        helper(root.left, res); 
    
        cur = root.val; 
        if (cur == pre) {
            curCount++; 
        } else {
            pre = cur; 
            curCount = 1; 
        }
        if (curCount == maxCount) {
            res[modeAmount] = cur; 
            modeAmount++; 
        }
        
        helper(root.right, res); 
    }
}