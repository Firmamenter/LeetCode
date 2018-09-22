/**
147. Insertion Sort List

Sort a linked list using insertion sort.
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
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);  
        while (head != null) {
            ListNode ite = dummy; 
            ListNode pre = null; 
            while (ite != null && head.val >= ite.val) {
                pre = ite; 
                ite = ite.next; 
            }
            pre.next = head; 
            ListNode temp = head.next; 
            head.next = ite; 
            head = temp; 
        }
        return dummy.next; 
    }
}


public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE); 
        ListNode pre = null; 
        ListNode ite = dummy; 
        ListNode temp; 
        
        while (head != null) {
            while (ite != null && head.val >= ite.val) {
                pre = ite; 
                ite = ite.next; 
            }
            pre.next = head; 
            temp = head.next; 
            head.next = ite; 
            head = temp;   
            ite = dummy; 
            pre = null; 
        }
        
        return dummy.next; 
    }
}