/**
148. Sort List

Sort a linked list in O(n log n) time using constant space complexity.

Example
Given 1->3->2->null, sort it to 1->2->3->null.

Solution: Quick Sort. Unsolved.
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
    private ListNode findLast(ListNode head, Boolean cut) {
        if (head == null || head.next == null) {
            return head; 
        }
        while (head.next.next != null) {
            head = head.next; 
        }
        
        ListNode temp = head.next; 
        if (cut == true) {
            head.next = null; 
        }
        return temp; 
    }
    
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head; 
        } else {
            ListNode last = findLast(head, true); 
            ListNode less = new ListNode(0); 
            ListNode lHead = less; 
            ListNode greater = new ListNode(0); 
            ListNode gHead = greater; 
            ListNode cur = head; 
            
            while (cur != null) {
                if (cur.val < last.val) {
                    lHead.next = cur; 
                    lHead = lHead.next; 
                } else {
                    gHead.next = cur; 
                    gHead = gHead.next; 
                }
                cur = cur.next; 
            }
            lHead.next = null; 
            gHead.next = null; 
            
            lHead = sortList(less.next); 
            gHead = sortList(greater.next); 
            
            ListNode lLast = findLast(lHead, false); 
            
            if (lLast != null) {
                lLast.next = last; 
                last.next = gHead; 
                return lHead; 
            } else {
                last.next = gHead; 
                return last; 
            }
        } 
    }
}
