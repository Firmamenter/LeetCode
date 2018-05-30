/**
144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

Solution: Iterate, traversal, divide & conquer.
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
//Time: O(n)    Space: O(h)
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        preorder(result, root); 
        return result; 
    }
    
    private void preorder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return null; 
        }
        
        result.add(root.val); 
        preorder(result, root.left); 
        preorder(result, root.right); 
    }
}

//Solution 2: Divide & Conquer
//Time: O(n)    Space: O(logn)(balanced tree) or O(n)(worst case, biased tree)
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        if (root == null) {
            return result; 
        }
        
        List<Integer> leftResult = new ArrayList<>(); 
        List<Integer> rightResult = new ArrayList<>();
        
        //Divide
        leftResult = preorderTraversal(root.left); 
        rightResult = preorderTraversal(root.right);
        
        //Conquer
        result.add(root.val); 
        result.addAll(leftResult); 
        result.addAll(rightResult); 
        
        return result; 
    }
}

//Solution 3: Iterate
//Time: O(n)    Space: O(logn)(balanced tree) or O(n)(worst case, biased tree)
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>(); 
        
        if (root == null) {
            return result; 
        }
        
        stack.push(root); 
        
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val); 
            if (temp.right != null) {
                stack.push(temp.right); 
            }
            if (temp.left != null) {
                stack.push(temp.left); 
            }
        }
        
        return result; 
    }
}

