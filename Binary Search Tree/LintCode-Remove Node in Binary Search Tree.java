/**
LintCode: Remove Node in Binary Search Tree

Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.

Solution: 
1.Find the target node.
2.If the target node does not have right subtree, father.left = target.left or father.right = target.left.
Otherwise, use the max value of left subtree to replace the removed target node.
(Attention: the maximum value in the left subtree must be either leaf node or node that has no right subtree.)
(So, at most 2 reconstruction of the BST are needed.)
3.return root.
(Attention: be careful about the situation that root is the target node!)
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
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode rootFather = new TreeNode(0); 
        rootFather.left = root; 
        
        TreeNode parent = findValue(rootFather, root, value); 
        if (parent.left != null && parent.left.val == value) {
            removeHelper(parent, parent.left); 
        } else if (parent.right != null && parent.right.val == value) {
            removeHelper(parent, parent.right); 
        } else {
            return rootFather.left; 
        }
        
        return rootFather.left; 
    }
    
    private TreeNode findValue(TreeNode father, TreeNode node, int value) {
        if (node == null || node.val == value) {
            return father; 
        }
        
        if (node.val < value) {
            return findValue(node, node.right, value); 
        } else {
            return findValue(node, node.left, value); 
        }
    }
    
    private void removeHelper(TreeNode father, TreeNode node) {
        if (node.left == null) {
            if (father.left == node) {
                father.left = node.right; 
            } else {
                father.right = node.right; 
            }
        } else {
            TreeNode temp = node.left; 
            TreeNode tempFather = node; 
            while (temp.right != null) {
                tempFather = temp; 
                temp = temp.right; 
            }
        
            if (tempFather.left == temp) {
                tempFather.left = temp.left; 
            } else {
                tempFather.right = temp.left; 
            }
        
            temp.left = node.left; 
            temp.right = node.right; 
            if (father.left == node) {
                father.left = temp; 
            } else {
                father.right = temp; 
            }
        }
    }
}