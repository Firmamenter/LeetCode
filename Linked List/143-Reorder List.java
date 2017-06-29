/**
143. Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

Solution: First find middle element, then reverse the latter part of list, finally merge two lists.
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
     * @param head: The head of linked list.
     * @return: void
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head.next; 
        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }
        return slow; 
    } 
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null; 
        while (head != null) {
            ListNode temp = head.next; 
            head.next = pre; 
            pre = head; 
            head = temp; 
        }
        return pre; 
    }
    
    private void merge(ListNode l1, ListNode l2) {
        ListNode head = l1; 
        l1 = l1.next; 
        int flag = 1; 
        while (l1 != null || l2 != null) {
            if (flag % 2 == 0) {
                head.next = l1; 
                l1 = l1.next; 
            } else {
                head.next = l2; 
                l2 = l2.next; 
            }
            head = head.next; 
            flag++; 
        }
        head.next = null; 
    }
    
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null || head.next.next == null) {
            return; 
        }
        
        ListNode middle = findMiddle(head); 
        ListNode right = middle.next; 
        middle.next = null; 
        
        ListNode rightHead = reverse(right); 
        
        merge(head, rightHead); 
    }
}
