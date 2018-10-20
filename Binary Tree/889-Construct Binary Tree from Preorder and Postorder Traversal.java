/**
889. Construct Binary Tree from Preorder and Postorder Traversal

Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
 

Note:

1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.

Sol: Tree
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1); 
    }
    
    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null; 
        }
        TreeNode root = new TreeNode(pre[preStart]); 
        int idx = preStart + 1; 
        for (int i = preStart + 1; i <= preEnd; i++) {
            if (pre[i] == post[postEnd - 1]) {
                idx = i; 
                break; 
            }
        }
        root.left = helper(pre, preStart + 1, idx - 1, post, postStart, postStart + idx - preStart - 2); 
        root.right = helper(pre, idx, preEnd, post, postStart + idx - preStart - 1, postEnd - 1); 
        return root; 
    }
}