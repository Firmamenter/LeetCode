/**
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Solution: Recursive.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2; 
        } else if (l2 == null) {
            return l1; 
        }
        
        ListNode head; 
        if (l1.val < l2.val) {
            head = l1; 
            l1.next = mergeTwoLists(l1.next, l2); 
        } else {
            head = l2; 
            l2.next = mergeTwoLists(l1, l2.next); 
        }
        
        return head; 
    }
}