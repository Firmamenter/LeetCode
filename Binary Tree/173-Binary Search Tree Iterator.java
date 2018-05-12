/**
173. Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Solution: Non-recursive inOrder traversal.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode cur = new TreeNode(0); 
    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        cur = root; 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (cur != null || !stack.empty()) {
            return true; 
        } else {
            return false; 
        }
    }

    /** @return the next smallest number */
    public int next() {
        int result = 0; 
        if (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur); 
                cur = cur.left; 
            }
            cur = stack.pop(); 
            result = cur.val; 
            cur = cur.right; 
        }
        return result; 
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */