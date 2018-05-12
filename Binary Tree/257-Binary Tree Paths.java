/**
257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

Solution: DFS.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>(); 
        if (root == null) {
            return res; 
        }
        helper(root, res, ""); 
        return res; 
    }
    
    private void helper(TreeNode root, List<String> res, String path) {
        if (root == null) {
            return; 
        }
        
        if (root.left == null && root.right == null) {
            res.add((path + "->" + root.val + "").substring(2)); 
        }
        
        helper(root.left, res, path + "->" + root.val + ""); 
        helper(root.right, res, path + "->" + root.val + ""); 
    }
}