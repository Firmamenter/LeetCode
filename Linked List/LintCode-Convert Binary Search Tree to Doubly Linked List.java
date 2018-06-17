/**
LintCode: Convert Binary Search Tree to Doubly Linked List

Description
Convert a binary search tree to doubly linked list with in-order traversal.
Have you met this question in a real interview?  Yes
Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3       
return 1<->2<->3<->4<->5

Sol: For-loop traversal. 
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) {
            return null; 
        }
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode cur = root; 
        DoublyListNode dummy = new DoublyListNode(0); 
        DoublyListNode head = dummy; 
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur); 
                cur = cur.left; 
            }
            cur = stack.pop(); 
            DoublyListNode temp = new DoublyListNode(cur.val); 
            head.next = temp; 
            temp.prev = head; 
            head = temp; 
            cur = cur.right; 
        }
        head = dummy.next; 
        head.prev = null; 
        return head; 
    }
}