/**
86. Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

Solution: Use two dummy nodes to partition the list.
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode less = new ListNode(0); 
        ListNode greater = new ListNode(0); 
        ListNode lHead = less; 
        ListNode gHead = greater; 
        
        while (head != null) {
            if (head.val < x) {
                lHead.next = head; 
                lHead = lHead.next; 
            } else {
                gHead.next = head; 
                gHead = gHead.next; 
            }
            head = head.next; 
        }
        
        lHead.next = greater.next; 
        gHead.next = null; 
        
        return less.next; 
    }
}