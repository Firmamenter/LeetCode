/**
LintCode: Max Tree

Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.

Example
Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:

    6
   / \
  5   3
 /   / \
2   0   1

Solution: Use stack to store information. Whenever find a element that is bigger than the top element in stack, pop it and construct a branch.
          Time: O(n).
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null; 
        }
        
        TreeNode root = new TreeNode(0);  
        Stack<TreeNode> stack = new Stack<>(); 
        
        for (int i = 0; i <= A.length; i++) {
            int key = (i == A.length) ? Integer.MAX_VALUE : A[i]; 
            TreeNode curTree = new TreeNode(key); 
            if (!stack.empty() && key < stack.peek().val) {
                stack.push(curTree); 
                continue; 
            }
            while (!stack.empty() && key > stack.peek().val) {
                TreeNode preTree = stack.pop(); 
                if (stack.empty()) {
                    curTree.left = preTree; 
                    root = curTree; 
                } else {
                    if (stack.peek().val < key) {
                        stack.peek().right = preTree; 
                        root = stack.peek(); 
                    } else {
                        curTree.left = preTree; 
                        root = curTree; 
                    }
                }
             }
             stack.push(curTree); 
        }
        return root.left; 
    }
}