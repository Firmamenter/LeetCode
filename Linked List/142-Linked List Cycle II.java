/**
142. Linked List Cycle II

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

Example
Given -21->10->4->5, tail connects to node index 1，return 10

Solution: First determine the existence of cycle, then two pointer from head and slow.
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if (head == null) {
            return head; 
        }
        
        ListNode slow = head; 
        ListNode fast = head; 
        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
            if (slow == fast) {
                break; 
            }
        }
        
        if (fast == null || fast.next == null) {
            return null; 
        }
        
        ListNode cur = head; 
        while (cur != slow) {
            slow = slow.next; 
            cur = cur.next; 
        }
        
        return cur; 
    }
}
