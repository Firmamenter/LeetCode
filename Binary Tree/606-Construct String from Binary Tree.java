/**
606. Construct String from Binary Tree

You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

Solution: PreOrder traversal.
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
public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return new String(); 
        }
        StringBuilder res = new StringBuilder(); 
        helper(t, res); 
        return res.toString(); 
    }
    
    private void helper(TreeNode t, StringBuilder res) {
        if (t.left == null && t.right == null) {
            res.append(t.val); 
            return; 
        }
        
        res.append(t.val); 
        if (t.left != null) {
            res.append("("); 
            helper(t.left, res); 
        } else {
            res.append("("); 
        }
        res.append(")"); 
        if (t.right != null) {
            res.append("("); 
            helper(t.right, res); 
        } else {
            res.append("("); 
        }
        res.append(")"); 
        if (res.charAt(res.length() - 2) == '(') {
            res.deleteCharAt(res.length() - 1); 
            res.deleteCharAt(res.length() - 1); 
        }
    }
}

class Solution {
    private String res = ""; 
    
    public String tree2str(TreeNode t) {
        if (t == null) {
            return res; 
        }
        helper(t); 
        return res; 
    }
    
    private void helper(TreeNode root) {
        res += root.val + ""; 
        boolean hasLeft = false; 
        if (root.left != null) {
            hasLeft = true; 
            res += "("; 
            helper(root.left); 
            res += ")"; 
        }
        if (root.right != null) {
            res += hasLeft ? "(" : "()("; 
            helper(root.right); 
            res += ")"; 
        } 
    }
}