/**
513. Find Bottom Left Tree Value

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.

Solution: BFS. 
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root); 
        TreeNode res = root; 
        while (!queue.isEmpty()) {
            res = queue.peek(); 
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll(); 
                if (temp.left != null) {
                    queue.offer(temp.left); 
                }
                if (temp.right != null) {
                    queue.offer(temp.right); 
                }
            }
        }
        return res.val; 
    }
}