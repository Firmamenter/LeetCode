/**
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
        }
        if (l2 == null) {
            return l1; 
        }
        ListNode header = null;
        if (l1.val <= l2.val) {
            header = l1;
            l1 = l1.next;
        } else {
            header = l2; 
            l2 = l2.next; 
        }
        ListNode ite = header;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ite.next = l1;
                ite = ite.next; 
                l1 = l1.next;
            } else {
                ite.next = l2; 
                ite = ite.next; 
                l2 = l2.next; 
            }
        }
        if (l1 != null) {
            ite.next = l1; 
        }
        if (l2 != null) {
            ite.next = l2; 
        }
        return header; 
    }
}