/**
206. Reverse Linked List

Reverse a singly linked list.

Solution: Use a temporary ListNode to store the next node of head.
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode pre = null; 
        while (head != null) {
            ListNode temp = head.next; 
            head.next = pre; 
            pre = head; 
            head = temp; 
        }
        
        return pre; 
    }
}