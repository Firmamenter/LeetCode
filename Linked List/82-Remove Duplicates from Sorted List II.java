/**
82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

Solution: Linked List, use dummy node.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode dummy = new ListNode(0); 
        dummy.next = head; 
        
        ListNode pre = dummy; 
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                pre = head; 
                head = head.next; 
                continue; 
            }
            while (head.next != null && head.val == head.next.val) {
                head = head.next; 
            }
            head = head.next; 
            pre.next = head; 
        }
        
        return dummy.next; 
    }
}