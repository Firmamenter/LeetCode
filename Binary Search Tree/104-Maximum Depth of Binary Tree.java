/**
104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Solution: Traversal, Divide & Conquer
*/

//Traversal 1
//Time: O(n)	Space: O(1)
//Use global counter may be tricky, be careful. Rudimentary data type used as function parameters can not remain the changes inside the fucntion.
public class Solution {
    private int curDepth = 0; 
    private int maxDepth = 0;
    
    public int maxDepth(TreeNode root) {
        findDepth(root); //The function will not change their value, if you pass curDepth and maxDepth as parameters here instead of class attributes,
        return maxDepth; 
    }
    
    private void findDepth(TreeNode root) {
        curDepth++; 
        if (root == null) {
            return; 
        }
        
        maxDepth = curDepth > maxDepth ? curDepth : maxDepth; 
        findDepth(root.left); 
        curDepth--; 
        findDepth(root.right); 
        curDepth--; 
    }
}

//Traversal 2
//Time: O(n)	Space: O(1)
//Use parameter as counter, do not need minus 1 depth when you go backward.
public class Solution {
    private int max = 0; 
    
    public int maxDepth(TreeNode root) {
        findMaxDepth(root, 1); 
        return max; 
    }
    
    private void findMaxDepth(TreeNode root, int curDepth) {
        if (root == null) {
            return; 
        }
        
        max = curDepth > max ? curDepth : max; 
        
        findMaxDepth(root.left, curDepth + 1); // Can not use curDepth++ or ++curDepth, because it will be used in the next line.
        findMaxDepth(root.right, curDepth + 1); 
    }
}

//Divide and Conquer
//Time: O(n)	Space: same as before.
public class Solution {
    public int maxDepth(TreeNode root) {
        int max = 0; 
        if (root == null) {
            return max; 
        }
        
        int left = maxDepth(root.left); 
        int right = maxDepth(root.right); 
        
        return Math.max(left, right) + 1; 
    }
}