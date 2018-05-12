/**
450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

Solution: Tree. Be clear about all situations. Basic procedure is 1) Find the node 2) Delete it. 
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
    // Find the node. 
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root; 
        if (root.val == key) return deleteHelper(root); 
        TreeNode cur = root; 
        while (cur != null) {
            if (cur.val > key) {
                if (cur.left == null) break; 
                else {
                    if (cur.left.val == key) {
                        cur.left = deleteHelper(cur.left); 
                        break; 
                    }
                    else cur = cur.left; 
                }
            } else {
                if (cur.right == null) break; 
                else {
                    if (cur.right.val == key) {
                        cur.right = deleteHelper(cur.right); 
                        break; 
                    }
                    else cur = cur.right; 
                }
            }
        }
        return root; 
    }
    
    // Delete it. 
    private TreeNode deleteHelper(TreeNode root) {
        if (root.left == null && root.right == null) return null; 
        if (root.left == null) {
            TreeNode pre = null; 
            TreeNode cur = root.right; 
            while (cur.left != null) {
                pre = cur; 
                cur = cur.left; 
            }
            root.val = cur.val; 
            if (pre != null) pre.left = cur.right; 
            else root.right = cur.right; 
        } else {
            TreeNode pre = null; 
            TreeNode cur = root.left; 
            while (cur.right != null) {
                pre = cur; 
                cur = cur.right; 
            }
            root.val = cur.val; 
            if (pre != null) pre.right = cur.left; 
            else root.left = cur.left; 
        }
        return root; 
    }
}