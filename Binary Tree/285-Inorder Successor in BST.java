/**
285. Inorder Successor in BST

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Solution: InOrder Traversal using stack.
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
// Standard inorder traversal template
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null; 
        }
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode cur = root; 
        boolean triger = false; 
        
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur); 
                cur = cur.left; 
            }
            if (triger) {
                return stack.pop(); 
            }
            cur = stack.pop(); 
            if (cur == p) {
                triger = true; 
            }
            cur = cur.right; 
        }
        
        return null; 
    }
}

//Time O(h)   Space O(h)
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null; 
        }
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode cur = root; 
        stack.push(root); 
        boolean triger = false; 
        
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                if (cur.left != null) {
                    stack.push(cur.left); 
                }
                cur = cur.left; 
            }
            if (triger) {
                return stack.pop(); 
            }
            cur = stack.pop(); 
            if (cur == p) {
                triger = true; 
            }
            if (cur.right != null) {
                stack.push(cur.right); 
            }
            cur = cur.right; 
        }
        
        return null; 
    }
}

//Time O(h)   Space O(1)
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null; 
        TreeNode successor = null; 
        while (root != null) {
            if (root.val <= p.val) root = root.right; 
            else {
                successor = root; 
                root = root.left; 
            }
        }
        return successor; 
    }
}