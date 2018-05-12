/**
94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

Solution: Traversal, Divide & Conquer, Iterate
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

//Solution 1: Traversal
//Time: O(n)    Space: O(1)
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        inOrder(result, root); 
        return result; 
    }
    
    private void inOrder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return; 
        }
        
        inOrder(result, root.left); 
        result.add(root.val); 
        inOrder(result, root.right); 
    }
}

//Solution 2: Divide & Conquer
//Time: O(n)    Space: O(logn)(balanced tree) or O(n)(worst case, biased tree)
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        if (root == null) {
            return result; 
        }
        
        List<Integer> leftResult = new ArrayList<>(); 
        List<Integer> rightResult = new ArrayList<>(); 
        
        //Divide
        leftResult = inorderTraversal(root.left); 
        rightResult = inorderTraversal(root.right); 
        
        //Conquer
        result.addAll(leftResult); 
        result.add(root.val); 
        result.addAll(rightResult); 
        
        return result; 
    }
}

//Solution 3: Iterate
//Time: O(n)    Space: O(logn)(balanced tree) or O(n)(worst case, biased tree)
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        Stack<TreeNode> stack = new Stack<>(); 
        
        if (root == null) {
            return result; 
        }
        
        TreeNode cur = root; 
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur); 
                cur = cur.left; 
            }
            cur = stack.pop();
            result.add(cur.val); 
            cur = cur.right; 
        }
        
        return result; 
    }
}