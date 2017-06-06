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
public class Solution {
    private class ResultType {  //If you want to create a new data structure, please use inner class. And be careful about the constructor.
        int singlePath; 
        int maxPath; 
        
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath; 
            this.maxPath = maxPath; 
        }
    }
    
    private ResultType findMaxPath(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE); //Think about it. Because other side of subtree may has minus maxPath, so here we use Integer.MIN_VALUE.
        }
        
        //Divide
        ResultType left = findMaxPath(root.left); 
        ResultType right = findMaxPath(root.right);
        
        //Combine
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val; 
        singlePath = Math.max(singlePath, 0); 
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val); 
        
        return new ResultType(singlePath, maxPath); 
    }
    
    public int maxPathSum(TreeNode root) {
        return findMaxPath(root).maxPath; 
    }
}