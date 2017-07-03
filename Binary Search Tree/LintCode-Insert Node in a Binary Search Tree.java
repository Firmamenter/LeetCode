/**
LintCode: Insert Node in a Binary Search Tree

Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

Notice:

You can assume there is no duplicate values in this tree + node.

Example:

Given binary search tree as follow, after Insert node 6, the tree should be:

  2             2
 / \           / \
1   4   -->   1   4
   /             / \ 
  3             3   6

Solution: Remember the inserted node will always be leaf!
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
//Time O(h)   Space O(h)
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node; 
        }
        
        //Divide
        TreeNode right = new TreeNode(0); 
        TreeNode left = new TreeNode(0); 
        if (node.val > root.val) {
            right = insertNode(root.right, node); 
        }
        if (node.val < root.val) {
            left = insertNode(root.left, node); 
        }
        
        //Combine
        if (right == node) {
            root.right = node; 
        }
        if (left == node) {
            root.left = node; 
        }
        
        return root; 
    }
}

//Time O(h)   Space O(1)
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root; 
        }
        TreeNode cur = root; 
        TreeNode successor = null; 
        while (cur != null && cur.val != p.val) {
            if (p.val < cur.val) {
                successor = cur; 
                cur = cur.left; 
            } else {
                cur = cur.right; 
            }
        }
        
        if (cur == null) {
            return cur; 
        }
        
        if (cur.right == null) {
            return successor; 
        }
        
        if (cur.right.left == null) {
            return cur.right; 
        }
        
        TreeNode ite = cur.right; 
        while (ite.left != null) {
            ite = ite.left; 
        }
        
        return ite; 
    }
}