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
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        ListNode left = null, mid = head, right = mid.next; 
        while (mid != null) {
            mid.next = left; 
            left = mid; 
            mid = right; 
            if (mid != null) {
                right = mid.next; 
            }
        }
        return left; 
    }
}

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