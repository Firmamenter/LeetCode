/**
543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

Solution: DC.
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
    private class ResultType {
        int single; 
        int max; 
        ResultType(int single, int max) {
            this.single = single; 
            this.max = max; 
        }
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        return helper(root).max - 1; 
    }
    
    private ResultType helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new ResultType(1, 1); 
        }
        
        if (root.left == null) {
            ResultType right = helper(root.right); 
            int single = right.single + 1; 
            return new ResultType(single, Math.max(single, right.max)); 
        }
        
        if (root.right == null) {
            ResultType left = helper(root.left); 
            int single = left.single + 1; 
            return new ResultType(single, Math.max(single, left.max)); 
        }
        
        ResultType left = helper(root.left); 
        ResultType right = helper(root.right); 
        int single = Math.max(left.single, right.single) + 1; 
        int max = Math.max(Math.max(left.max, right.max), left.single + right.single + 1); 
        return new ResultType(single, max); 
    }
}

public class Solution {
    private class ResultType {
        int leftLen; 
        int rightLen; 
        int max; 
        ResultType(int leftLen, int rightLen, int max) {
            this.leftLen = leftLen; 
            this.rightLen = rightLen; 
            this.max = max; 
        }
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        return helper(root).max - 1; 
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0); 
        }
        
        //Divide 
        ResultType left = helper(root.left); 
        ResultType right = helper(root.right); 
        
        //Combine 
        int maxLen = Math.max(left.leftLen, left.rightLen) + 1 + Math.max(right.leftLen, right.rightLen); 
        maxLen = Math.max(left.max, Math.max(right.max, maxLen)); 
        return new ResultType(Math.max(left.leftLen, left.rightLen) + 1, Math.max(right.leftLen, right.rightLen) + 1, maxLen); 
    }
}