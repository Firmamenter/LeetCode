/**
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Solution: Divide and Conquer
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

// DC. 
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        
        int left = minDepth(root.left); 
        int right = minDepth(root.right); 
        
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1; 
    }
}

// DFS.
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0; 
        if (root.left == null) return minDepth(root.right) + 1; 
        if (root.right == null) return minDepth(root.left) + 1; 
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1; 
    }
}

// BFS.
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0; 
        int minLevel = 0; 
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root); 
        while (!queue.isEmpty()) {
            minLevel++; 
            int len = queue.size(); 
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll(); 
                if (temp.left == null && temp.right == null) {
                    return minLevel; 
                }
                if (temp.left != null) {
                    queue.offer(temp.left); 
                }
                if (temp.right != null) {
                    queue.offer(temp.right); 
                }
            }
        }
        return minLevel; 
    }
}