/**
199. Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Sol: BFS. 
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        if (root == null) return res; 
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root); 
        while (!queue.isEmpty()) {
            int len = queue.size(); 
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll(); 
                if (i == len - 1) res.add(cur.val); 
                if (cur.left != null) queue.offer(cur.left); 
                if (cur.right != null) queue.offer(cur.right); 
            }
        }
        return res; 
    }
}