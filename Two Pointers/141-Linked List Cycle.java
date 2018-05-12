/**
141. Linked List Cycle

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

Solution: Two Pointers with different speed. 

Why can the faster pointer catch up the slower pointer? By induction. Each step, the distance between faster pointer and
slower pointer will decrease by 1. Faster pointer will must encounter the slower one in one cycle.
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

// New simple version. 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false; 
        }
        ListNode slow = head.next; 
        ListNode fast = head.next.next; 
        while (fast != slow) {
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                return false; 
            }
            slow = slow.next; 
            fast = fast.next.next; 
        }
        return true; 
    }
}