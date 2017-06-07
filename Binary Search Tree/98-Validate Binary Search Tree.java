/**
98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

Solution: Divide and Conquer.
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

//My version.
public class Solution {
    private class ResultType {
        int maxValue; 
        int minValue; 
        boolean isBST; 
    }
    
    private ResultType isValid(TreeNode root) {
        if (root == null) {
            return null; 
        }
        
        //Divide
        ResultType left = isValid(root.left); 
        ResultType right = isValid(root.right); 
        
        //Combine
        ResultType result = new ResultType(); 
        if (left == null && right == null) {
            result.maxValue = root.val; 
            result.minValue = root.val; 
            result.isBST = true; 
            return result;
        } else if (left == null) {
            if (right.isBST && right.minValue > root.val) {
                result.maxValue = right.maxValue; 
                result.minValue = root.val; 
                result.isBST = true; 
            } else {
                result.isBST = false; 
            }
        } else if (right == null) {
            if (left.isBST && left.maxValue < root.val) {
                result.maxValue = root.val; 
                result.minValue = left.minValue; 
                result.isBST = true; 
            } else {
                result.isBST = false; 
            }
        } else if (left.isBST && right.isBST && left.maxValue < root.val && right.minValue > root.val) {
            result.maxValue = right.maxValue;
            result.minValue = left.minValue;
            result.isBST = true; 
        } else {
            result.isBST = false; 
        }
        
        return result; 
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true; 
        }
        return isValid(root).isBST; 
    }
}

//Simplified version.
public class Solution {
    private class ResultType {
        int maxValue; 
        int minValue; 
        boolean isBST; 
        ResultType (int maxValue, int minValue, boolean isBST) {
            this.maxValue = maxValue; 
            this.minValue = minValue; 
            this.isBST = isBST; 
        }
    }
    
    private ResultType isValid(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, true); 
        }
        
        //Divide
        ResultType left = isValid(root.left); 
        ResultType right = isValid(root.right); 
        
        //Combine
        if (!left.isBST || !right.isBST) {
            return new ResultType(0, 0, false); 
        }
        
        if (root.left != null && left.maxValue >= root.val || root.right != null && right.minValue <= root.val) {
            return new ResultType(0, 0, false); 
        }
        
        return new ResultType(Math.max(right.maxValue, root.val), Math.min(left.minValue, root.val), true); 
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValid(root).isBST; 
    }
}