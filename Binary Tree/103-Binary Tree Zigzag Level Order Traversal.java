/**
103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

Solution: BFS, DFS.
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
//BFS.
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(res.get(i)); 
            }
        }
        
        return res; 
    }
}

//DFS.
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        helper(root, 0, res); 
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(res.get(i)); 
            }
        }
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