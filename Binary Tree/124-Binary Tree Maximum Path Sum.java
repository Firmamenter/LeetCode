/**
124. Binary Tree Maximum Path Sum

Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

Solution: Divide and Conquer. Whenever you use Divide and Conquer, the most important things are General case and Base case!
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
    
    public int maxPathSum(TreeNode root) {
        return helper(root).max; 
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE); 
        }
        
        // Divide 
        ResultType left = helper(root.left); 
        ResultType right = helper(root.right); 
        
        // Combine 
        int single = root.val + Math.max(0, Math.max(left.single, right.single)); 
        int max = Math.max(Math.max(left.max, right.max), root.val + Math.max(0, left.single) + Math.max(0, right.single)); 
        return new ResultType(single, max); 
    }
}