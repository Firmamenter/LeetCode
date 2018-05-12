/**
99. Recover Binary Search Tree

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

Solution: Morris Traversal. 
*/

// Morris Traversal: 3步. 1.找到前驱节点建立辅助结构 2.遍历 3.删除辅助节点，恢复树结构
// 参考: http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
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
    public void recoverTree(TreeNode root) {
        if (root == null) return; 
        TreeNode large = null, small = null, pre = null; 
        while (root != null) {
            TreeNode temp = root.left; 
            if (temp != null) {
                while (temp.right != null && temp.right != root) temp = temp.right; 
                if (temp.right == null) {
                    temp.right = root; 
                    root = root.left; 
                } else {
                    if (pre != null && pre.val > root.val) {
                        if (large == null) {
                            large = pre; 
                            small = root; 
                        }
                        else small = root; 
                    }
                    temp.right = null; 
                    pre = root; 
                    root = root.right; 
                }
            } else {
                if (pre != null && pre.val > root.val) {
                        if (large == null) {
                            large = pre; 
                            small = root; 
                        }
                        else small = root; 
                }
                pre = root; 
                root = root.right; 
            }
        }
        int swap = large.val; 
        large.val = small.val; 
        small.val = swap; 
    }
}

// Better than the below one. 
class Solution {
    private int small = 0, large = 0; 
    
    public void recoverTree(TreeNode root) {
        if (root == null) return; 
        List<Integer> list = new ArrayList<>(); 
        inOrderTraverse(root, list, false); 
        boolean isLargeFound = false; 
        for (int i = 0; i < list.size(); i++) {
            if (!isLargeFound && list.get(i) > list.get(i + 1)) {
                large = list.get(i); 
                isLargeFound = true; 
                continue; 
            }
            if (isLargeFound && list.get(i) < list.get(i - 1)) {
                small = list.get(i); 
            }
        }
        inOrderTraverse(root, list, true); 
    }
    
    private void inOrderTraverse(TreeNode root, List<Integer> list, boolean replace) {
        if (root == null) return; 
        
        inOrderTraverse(root.left, list, replace); 
        if (!replace) list.add(root.val); 
        else {
            if (root.val == small) root.val = large; 
            else if (root.val == large) root.val = small; 
        }
        inOrderTraverse(root.right, list, replace); 
    }
}

// O(n) space. 先Inorder遍历找到并记录异常点，再遍历一遍交换异常值即可，需要用到List记录Inorder遍历的结果
class Solution {
    private int small = 0, large = 0; 
    
    public void recoverTree(TreeNode root) {
        if (root == null) return; 
        List<Integer> list = new ArrayList<>(); 
        inOrderTraverse(root, list, false); 
        boolean isLargeFound = false; 
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.get(0) > list.get(1)) {
                    large = list.get(0); 
                    isLargeFound = true; 
                }
                continue; 
            }
            if (i == list.size() - 1) {
                if (list.get(list.size() - 1) < list.get(list.size() - 2)) small = list.get(list.size() - 1); 
                continue; 
            } 
            if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                if (isLargeFound) continue; 
                large = list.get(i); 
                isLargeFound = true; 
                continue; 
            }
            if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                small = list.get(i); 
                continue; 
            }
        }
        System.out.println(small); 
        System.out.println(large); 
        inOrderTraverse(root, list, true); 
    }
    
    private void inOrderTraverse(TreeNode root, List<Integer> list, boolean replace) {
        if (root == null) return; 
        
        inOrderTraverse(root.left, list, replace); 
        if (!replace) list.add(root.val); 
        else {
            if (root.val == small) root.val = large; 
            else if (root.val == large) root.val = small; 
        }
        inOrderTraverse(root.right, list, replace); 
    }
}