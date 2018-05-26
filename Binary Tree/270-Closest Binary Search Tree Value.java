/**
270. Closest Binary Search Tree Value

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4

Solution: while loop traverse BST. 
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
    public int closestValue(TreeNode root, double target) {
        int res = 0; 
        double diff = Double.MAX_VALUE; 
        
        while (root != null) {
            if (Math.abs(root.val - target) < diff) {
                diff = Math.abs(root.val - target); 
                res = root.val; 
            }
            if (root.val < target) {
                root = root.right; 
            } else {
                root = root.left; 
            }
        }
        
        return res; 
    }
}