/**
141. Linked List Cycle

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

Solution: Two Pointers with different speed. 
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; 
        }
        if (head.next == head) {
            return true;
        }
        
        ListNode i = head; 
        ListNode j = head.next; 
        for (; (i.next != null) && (j.next != null); ) {
            if (i == j) {
                return true;
            } else {
                i = i.next;
                if (j.next.next != null) {
                    j = j.next.next;   
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}