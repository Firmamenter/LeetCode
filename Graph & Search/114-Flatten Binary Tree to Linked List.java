/**
114. Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

Solution: DFS or Stack. Pre-order traversal. 
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

// Time O(n)    Space: O(h) 
// Top -> down
class Solution {
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return; 
        Stack<TreeNode> stack = new Stack<>(); 
        stack.push(root); 
        TreeNode pre = root; 
        TreeNode cur = null; 
        while (!stack.empty()) {
            cur = stack.pop(); 
            if (cur.right != null) stack.push(cur.right); 
            if (cur.left != null) stack.push(cur.left); 
            pre.left = null; 
            pre.right = cur; 
            pre = cur; 
        }
    }
}

// Bottom -> up
class Solution {
    private TreeNode pre = null; 
    
    public void flatten(TreeNode root) {
        if (root == null) return; 
        if (root.right != null) flatten(root.right); 
        if (root.left != null) flatten(root.left); 
        root.right = pre; 
        root.left = null; 
        pre = root; 
    }
}