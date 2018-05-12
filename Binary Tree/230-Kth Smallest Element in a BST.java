/**
230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Sol: 见下. 
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
// In-order traversal. Time O(k)	Space O(1)
class Solution {
    private int res = 0; 
    private int count = 0; 
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k); 
        return res; 
    }
    
    private void inOrder(TreeNode root, int k) {
        if (root == null) return; 
        
        inOrder(root.left, k); 
        if (++count == k) res = root.val;  
        inOrder(root.right, k); 
    }
}

// Follow Up
/**
如果BST节点TreeNode的属性可以扩展，则再添加一个属性leftCnt，记录左子树的节点个数

记当前节点为node

当node不为空时循环：

若k == node.leftCnt + 1：则返回node

否则，若k > node.leftCnt：则令k -= node.leftCnt + 1，令node = node.right

否则，node = node.left

O(height)
*/