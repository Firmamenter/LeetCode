/**
404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

Solution: Tree.
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
    private int sum = 0; 
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum; 
        }
        helper(root, null); 
        return sum; 
    }
    
    private void helper(TreeNode root, TreeNode parent) {
        if (root.left == null && root.right == null) {
            if (parent != null && parent.left == root) {
                sum += root.val; 
            }
            return; 
        }
        
        if (root.left != null) {
            helper(root.left, root); 
        }
        if (root.right != null) {
            helper(root.right, root); 
        }
    }
}