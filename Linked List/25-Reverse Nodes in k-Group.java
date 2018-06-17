/**
25. Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode nextHead; 
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head; 
        }
        int len = 0; 
        ListNode ite = head; 
        while (ite != null) {
            len++; 
            ite = ite.next; 
        }
        ListNode dummy = new ListNode(0); 
        ListNode pre = dummy; 
        for (int i = 0; i < len / k; i++) {
            ListNode tail = reverseList(head, k); 
            pre.next = tail; 
            pre = head; 
            head = nextHead; 
        }
        if (len % k != 0) {
            pre.next = head; 
        }
        return dummy.next; 
    }
    
    private ListNode reverseList(ListNode head, int k) {
        ListNode left = null; 
        ListNode right = head.next; 
        while (head != null && k > 0) {
            head.next = left; 
            left = head; 
            head = right; 
            if (head != null) {
                right = head.next; 
            }
            k--; 
        }
        nextHead = head; 
        return left; 
    }
}