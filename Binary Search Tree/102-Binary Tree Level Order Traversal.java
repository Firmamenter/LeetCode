/**
102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

Solution: BFS template. BFS will definitely use Queue! Remember it!
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); 
        
        if (root == null) {
            return result; 
        }
        
        Queue<TreeNode> queue = new LinkedList<>(); //Queue is a interface, it has no constructor. Different from stack.
        queue.offer(root); 
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(); 
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll(); 
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right); 
                }
                level.add(temp.val); 
            }
            result.add(level); 
        }
        
        return result; 
    }
}

//DFS
public class Solution {
    private int maxLevel = 0; 
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        helper(root, 0, res);
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