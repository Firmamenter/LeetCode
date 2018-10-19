/**
145. Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

Solution: Traversal, Divide & Conquer, Iterate.
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        postOrder(result, root);
        return result; 
    }
    
    private void postOrder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return; 
        }
        
        postOrder(result, root.left); 
        postOrder(result, root.right); 
        result.add(root.val);
    }
}

//Solution 2: Divide & Conquer
//Time: O(n)    Space: O(logn)(balanced tree) or O(n)(worst case, biased tree)
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        if (root == null) {
            return result; 
        }
        
        List<Integer> leftResult = new ArrayList<>(); 
        List<Integer> rightResult = new ArrayList<>(); 
        
        //Divide
        leftResult = postorderTraversal(root.left); 
        rightResult = postorderTraversal(root.right); 
        
        //Conquer
        result.addAll(leftResult); 
        result.addAll(rightResult); 
        result.add(root.val); 
        
        return result; 
    }
}

//Solution 3: Iterate
//Time: O(n)    Space: O(logn)(balanced tree) or O(n)(worst case, biased tree)
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        Stack<TreeNode> stack = new Stack<>(); 
        
        if (root == null) {
            return result; 
        }
        
        stack.push(root); 
        
        while (!stack.empty()) {
            TreeNode temp = stack.pop(); 
            result.add(temp.val); 
            if (temp.left != null) {
                stack.push(temp.left); 
            }
            if (temp.right != null) {
                stack.push(temp.right); 
            }
        }
        
        Collections.reverse(result); 
        return result; 
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        if (root == null) {
            return res; 
        }
        Set<TreeNode> isVisited = new HashSet<>(); 
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode cur = root; 
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur); 
                cur = cur.left; 
            }
            cur = stack.pop(); 
            if (!isVisited.add(cur)) {
                res.add(cur.val); 
                isVisited.remove(cur); 
                cur = null; 
            } else {
                stack.push(cur); 
                cur = cur.right; 
            }
        }
        return res; 
    }
}