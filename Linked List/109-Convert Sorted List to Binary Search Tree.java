/**
109. Convert Sorted List to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
// Time O(nlogn)
class Solution {
    private ListNode findMid(ListNode head) {
        ListNode pre = null; 
        ListNode slow = head; 
        ListNode fast = head.next; 
        while (fast != null && fast.next != null) {
            pre = slow; 
            slow = slow.next; 
            fast = fast.next.next; 
        }
        if (pre != null) {
            pre.next = null; 
        }
        return slow; 
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null; 
        }
        if (head.next == null) {
            return new TreeNode(head.val); 
        }
        ListNode mid = findMid(head); 
        ListNode after = mid.next; 
        TreeNode root = new TreeNode(mid.val); 
        if (head != mid) {
            root.left = sortedListToBST(head); 
        }
        root.right = sortedListToBST(after); 
        return root; 
    }
}

// Very hard. Time O(n) 自底向上
public class Solution {
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        cur = head;
        return sortedListToBST(0, count - 1);
    }
    
    private TreeNode sortedListToBST(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo)/ 2;
        TreeNode left = sortedListToBST(lo, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = sortedListToBST(mid + 1, hi);
        root.left = left;
        root.right = right;
        return root;
    }
}