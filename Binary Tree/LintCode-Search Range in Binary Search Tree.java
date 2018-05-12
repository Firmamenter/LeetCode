/**
LintCode: Search Range in Binary Search Tree

Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

Example:

If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

    20
   /  \
  8   22
 / \
4   12

Solution: InOrder Traversal. Divide and Conquer.
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

//InOrder Traversal. (Can be improved by the method in second version.)
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>(); 
        search(root, k1, k2, result);
        return result; 
    }
    
    private void search(TreeNode root, int k1, int k2, List<Integer> result) {
        if (root == null) {
            return; 
        }
        
        search(root.left, k1, k2, result); 
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val); 
        }
        search(root.right, k1, k2, result); 
    }
}

//Divide and Conquer. (Still inorder)
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>(); 
        if (root == null) {
            return result; 
        }
        
        //Divide
        ArrayList<Integer> left = new ArrayList<>(); 
        ArrayList<Integer> right = new ArrayList<>(); 
        if (root.val > k1) {
            left = searchRange(root.left, k1, k2); 
        }
        if (root.val < k2) {
            right = searchRange(root.right, k1, k2); 
        }
        
        //Combine
        if (left != null) {
            result.addAll(left); 
        }
        if (root.val <= k2 && root.val >= k1) {
            result.add(root.val); 
        } 
        if (right != null) {
            result.addAll(right); 
        }
        
        return result;     
    }
}