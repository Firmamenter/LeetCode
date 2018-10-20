/**
449. Serialize and Deserialize BST

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

Sol: PreOrder and InOrder reconstruction. 
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return ""; 
        }
        StringBuilder res = new StringBuilder(); 
        Stack<TreeNode> stack = new Stack<>(); 
        stack.push(root); 
        while (!stack.empty()) {
            TreeNode cur = stack.pop(); 
            res.append(cur.val + "" + ","); 
            if (cur.right != null) {
                stack.push(cur.right); 
            }
            if (cur.left != null) {
                stack.push(cur.left); 
            }
        }
        res.deleteCharAt(res.length() - 1); 
        System.out.println(res); 
        return res.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null; 
        }
        String[] strPreorder = data.split(","); 
        int[] preOrder = new int[strPreorder.length]; 
        for (int i = 0; i < strPreorder.length; i++) {
            preOrder[i] = Integer.valueOf(strPreorder[i]); 
        }
        int[] inOrder = preOrder.clone(); 
        Arrays.sort(inOrder); 
        return deserializeHelper(preOrder, 0, inOrder, 0, inOrder.length - 1); 
    }
    
    private TreeNode deserializeHelper(int[] preOrder, int preStart, int[] inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null; 
        }
        TreeNode root = new TreeNode(preOrder[preStart]); 
        int idx = inStart; 
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preStart]) {
                idx = i; 
                break; 
            }
        }
        root.left = deserializeHelper(preOrder, preStart + 1, inOrder, inStart, idx - 1); 
        root.right = deserializeHelper(preOrder, preStart + 1 + idx - inStart, inOrder, idx + 1, inEnd); 
        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));