/**
437. Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

Solution: DFS. 
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
// O(n)
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>(); 
        preSum.put(0, 1); 
        return helper(root, sum, 0, preSum); 
    }
    
    private int helper(TreeNode root, int target, int acc, Map<Integer, Integer> preSum) {
        if (root == null) {
            return 0; 
        }
        
        int curSum = acc + root.val; 
        
        int res = 0; 
        if (preSum.containsKey(curSum - target)) {
            res += preSum.get(curSum - target); 
        }
        
        if (preSum.containsKey(curSum)) {
            preSum.put(curSum, preSum.get(curSum) + 1); 
        } else {
            preSum.put(curSum, 1); 
        }
        res += helper(root.left, target, curSum, preSum) + helper(root.right, target, curSum, preSum); 
        preSum.put(curSum, preSum.get(curSum) - 1); 
        return res; 
    }
}

// O(nlogn) or O(n^2)
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0; 
        }
        return helper(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum); 
    }
    
    private int helper(TreeNode root, int sum, int acc) {
        if (root == null) {
            return 0; 
        }
        int res = 0; 
        if (acc + root.val == sum) {
            res++; 
        }
        
        //Divide 
        int left = helper(root.left, sum, acc + root.val); 
        int right = helper(root.right, sum, acc + root.val); 
        
        //Combine 
        return res += left + right; 
    }
}