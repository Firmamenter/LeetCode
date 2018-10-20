/**
95. Unique Binary Search Trees II

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

Solution: Recursion. 用到了返回值是List的函数，值得注意，因为这里每次新加入list的node都是new出来的，所以不会有重复现象。
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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>(); 
        return helper(1, n); 
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>(); 
        if (start > end) {
            list.add(null); 
            return list; 
        }
        if (start == end) {
            list.add(new TreeNode(start)); 
            return list; 
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = helper(start, i - 1); 
            List<TreeNode> rightNodes = helper(i + 1, end); 
            for (int l = 0; l < leftNodes.size(); l++) {
                for (int r = 0; r < rightNodes.size(); r++) {
                    TreeNode newRoot = new TreeNode(i); 
                    newRoot.left = leftNodes.get(l); 
                    newRoot.right = rightNodes.get(r); 
                    list.add(newRoot); 
                }
            }
        }
        return list; 
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>(); 
        }
        return generator(1, n); 
    }
    
    private List<TreeNode> generator(int start, int end) {
        if (start > end) {
            List<TreeNode> res = new ArrayList<>(); 
            res.add(null); 
            return res; 
        }
        List<TreeNode> list = new ArrayList<>(); 
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generator(start, i - 1); 
            List<TreeNode> rightNodes = generator(i + 1, end); 
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i); 
                    root.left = leftNode; 
                    root.right = rightNode; 
                    list.add(root); 
                }
            }
        }
        return list; 
    }
}