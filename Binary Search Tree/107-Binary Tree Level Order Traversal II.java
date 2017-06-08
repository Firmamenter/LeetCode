/**
107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

SOlution: BFS, DFS.
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

//BFS
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (root == null) {
            return res; 
        }
        
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root); 
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(); 
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll(); 
                level.add(temp.val); 
                if (temp.left != null) {
                    queue.offer(temp.left); 
                }
                if (temp.right != null) {
                    queue.offer(temp.right); 
                }
            }
            res.add(level); 
        }
        Collections.reverse(res);
        return res; 
    }
}

//DFS
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        helper(root, 0, res); 
        Collections.reverse(res); 
        return res; 
    }
    
    private void helper(TreeNode root, int height, List<List<Integer>> res) {
        if (root == null) {
            return; 
        }
        if (res.size() <= height) {
            res.add(new ArrayList<Integer>()); 
        }
        
        res.get(height).add(root.val); 
        
        helper(root.left, height + 1, res); 
        helper(root.right, height + 1, res); 
    }
}