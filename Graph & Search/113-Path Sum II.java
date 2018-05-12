/**
113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (root == null) {
            return res; 
        }
        helper(res, new ArrayList<Integer>(), root, sum); 
        return res; 
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return; 
        }
        
        list.add(root.val); 
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<Integer>(list)); 
            list.remove(list.size() - 1); 
            return; 
        }
        helper(res, list, root.left, sum - root.val); 
        helper(res, list, root.right, sum - root.val); 
        list.remove(list.size() - 1); 
    }
}