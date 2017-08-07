/**
653. Two Sum IV - Input is a BST

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

Solution: Inorder traverse and hashset. 
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>(); 
        return helper(root, k, set); 
    }
    
    private boolean helper(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false; 
        }
        
        //Divide 
        boolean left = helper(root.left, k, set); 
        boolean right = helper(root.right, k, set); 
        
        if (set.contains(k - root.val)) {
            return true; 
        } else {
            set.add(root.val); 
        }

        //Combine 
        return left || right; 
    }
}