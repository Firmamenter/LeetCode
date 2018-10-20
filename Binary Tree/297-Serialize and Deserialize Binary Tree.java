/**
297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

Sol: BFS or DFS. 
*/

// First BFS traditional version. Idea is correct, but leetcode is a fucking son of bitch who makes my method ETL. 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = ""; 
        if (root == null) {
            return res; 
        }
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root); 
        while (true) {
            int size = queue.size(); 
            boolean hasTreeNode = false; 
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll(); 
                if (cur != null) {
                    hasTreeNode = hasTreeNode || cur.left != null || cur.right != null; 
                    res += cur.val + "" + ","; 
                    queue.offer(cur.left); 
                    queue.offer(cur.right); 
                } else {
                    res += "null,"; 
                    queue.offer(null); 
                    queue.offer(null); 
                }
            }
            if (!hasTreeNode) {
                break; 
            }
        }
        int len = res.length(); 
        res = res.substring(0, len - 1); 
        //System.out.println(res); 
        return res; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null; 
        }
        String[] strArr = data.split(","); 
        if (strArr[0].equals("null")) {
            return null; 
        }
        TreeNode[] treeNodes = new TreeNode[strArr.length]; 
        int idx = 1; 
        treeNodes[0] = new TreeNode(Integer.valueOf(strArr[0])); 
        while (idx * 2 <= strArr.length) {
            if (!strArr[idx - 1].equals("null")) {
                if (treeNodes[idx - 1] == null) {
                    treeNodes[idx - 1] = new TreeNode(Integer.valueOf(strArr[idx - 1])); 
                }
                if (!strArr[idx * 2 - 1].equals("null")) {
                    treeNodes[idx * 2 - 1] = new TreeNode(Integer.valueOf(strArr[idx * 2 - 1])); 
                    treeNodes[idx - 1].left = treeNodes[idx * 2 - 1]; 
                }
                if (idx * 2 + 1 <= strArr.length && !strArr[idx * 2].equals("null")) {
                    treeNodes[idx * 2] = new TreeNode(Integer.valueOf(strArr[idx * 2])); 
                    treeNodes[idx - 1].right = treeNodes[idx * 2]; 
                }
            } 
            idx++; 
        }
        return treeNodes[0]; 
    }
}

// Improved BFS version.
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = ""; 
        if (root == null) {
            return res; 
        }
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root); 
        while (true) {
            int size = queue.size(); 
            boolean hasTreeNode = false; 
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll(); 
                if (cur != null) {
                    hasTreeNode = hasTreeNode || cur.left != null || cur.right != null; 
                    res += cur.val + "" + ","; 
                    queue.offer(cur.left); 
                    queue.offer(cur.right); 
                } else {
                    res += "null,"; 
                }
            }
            if (!hasTreeNode) {
                break; 
            }
        }
        int len = res.length(); 
        res = res.substring(0, len - 1); 
        System.out.println(res); 
        return res; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null; 
        }
        String[] strArr = data.split(","); 
        if (strArr[0].equals("null")) {
            return null; 
        }
        TreeNode[] treeNodes = new TreeNode[strArr.length]; 
        int idx = 1; 
        for (int i = 0; i < treeNodes.length; i++) {
            if (!strArr[i].equals("null")) {
                if (treeNodes[i] == null) {
                    treeNodes[i] = new TreeNode(Integer.valueOf(strArr[i])); 
                }
                if (idx < treeNodes.length && !strArr[idx].equals("null")) {
                    treeNodes[idx] = new TreeNode(Integer.valueOf(strArr[idx])); 
                    treeNodes[i].left = treeNodes[idx]; 
                }
                idx++; 
                if (idx < treeNodes.length && !strArr[idx].equals("null")) {
                    treeNodes[idx] = new TreeNode(Integer.valueOf(strArr[idx])); 
                    treeNodes[i].right = treeNodes[idx]; 
                }
                idx++; 
            }
        }
        return treeNodes[0]; 
    }
}

// DFS preorder version.
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return ""; 
        }
        StringBuilder res = new StringBuilder(); 
        serializeHelper(res, root); 
        res.deleteCharAt(res.length() - 1); 
        return res.toString(); 
    }
    
    private void serializeHelper(StringBuilder res, TreeNode root) {
        if (root == null) {
            res.append("null,"); 
            return; 
        }
        res.append(root.val + "" + ","); 
        serializeHelper(res, root.left); 
        serializeHelper(res, root.right); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null; 
        }
        String[] strArr = data.split(","); 
        List<String> list = new ArrayList<>(Arrays.asList(strArr)); 
        if (strArr[0].equals("null")) {
            return null; 
        }
        return deserializeHelper(list); 
    }
    
    private TreeNode deserializeHelper(List<String> list) {
        if (list.size() == 0) {
            return null; 
        }
        if (list.get(0).equals("null")) {
            list.remove(0); 
            return null; 
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0))); 
        list.remove(0); 
        root.left = deserializeHelper(list); 
        root.right = deserializeHelper(list); 
        return root; 
    }
}

// Slightly improved DFS version. 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return ""; 
        }
        StringBuilder res = new StringBuilder(); 
        serializeHelper(res, root); 
        res.deleteCharAt(res.length() - 1); 
        return res.toString(); 
    }
    
    private void serializeHelper(StringBuilder res, TreeNode root) {
        if (root == null) {
            res.append("null,"); 
            return; 
        }
        res.append(root.val + "" + ","); 
        serializeHelper(res, root.left); 
        serializeHelper(res, root.right); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null; 
        }
        String[] strArr = data.split(","); 
        List<String> list = new ArrayList<>(Arrays.asList(strArr)); 
        Collections.reverse(list); 
        if (strArr[0].equals("null")) {
            return null; 
        }
        return deserializeHelper(list); 
    }
    
    private TreeNode deserializeHelper(List<String> list) {
        if (list.size() == 0) {
            return null; 
        }
        if (list.get(list.size() - 1).equals("null")) {
            list.remove(list.size() - 1); 
            return null; 
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(list.size() - 1))); 
        list.remove(list.size() - 1); 
        root.left = deserializeHelper(list); 
        root.right = deserializeHelper(list); 
        return root; 
    }
}