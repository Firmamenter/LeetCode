/**
92. Reverse Linked List II

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 <= m <= n <= length of list.

Solution: Use dummy node. since the head can be reversed. 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head; 
        }
        
        ListNode dummy = new ListNode(0); 
        dummy.next = head; 
        ListNode preM = dummy; 
        for (int i = 1; i < m; i++) {
            preM = preM.next; 
        }
        
        ListNode mth = preM.next; 
        ListNode nth = null; 
        
        ListNode ite = mth; 
        ListNode pre = null; 
        ListNode temp = null; 
        int len = n - m + 1; 
        while (len > 0) {
            temp = ite.next; 
            ite.next = pre; 
            pre = ite; 
            ite = temp; 
            len--; 
        }
        nth = pre; 
        ListNode afterN = ite; 
        
        preM.next = nth; 
        mth.next = afterN; 
        
        return dummy.next; 
    }
}