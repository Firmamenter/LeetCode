/**
148. Sort List - Merge Sort.

Sort a linked list in O(n log n) time using constant space complexity.

Solution: Merge sort and quick sort. Should know merge sort for linked list merely needs O(1) space.
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

//Merge Sort. Theoretically, this method shall work, but merge using recursion will cause stack overflow.
public class Solution {
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head.next; 
        while (fast != null && fast.next != null) {
            fast = fast.next.next; 
            slow = slow.next; 
        }
        
        return slow; 
    } 
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2; 
        } else if (l2 == null) {
            return l1; 
        }
        
        ListNode head = null; 
        if (l1.val < l2.val) {
            head = l1; 
            head.next = merge(l1.next, l2); 
        } else {
            head = l2; 
            head.next = merge(l1, l2.next); 
        }
        
        return head; 
    }
     
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null) {
            return head; 
        }
        
        ListNode middle = findMiddle(head); 
        if (middle.next != null) {
            ListNode temp = middle.next; 
            ListNode head2 = sortList(temp); 
            middle.next = null; 
            ListNode head1 = sortList(head); 
            return merge(head1, head2); 
        } else {
            return head; 
        }
    }
}

//Non recursion merge method.
public class Solution {
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head.next; 
        while (fast != null && fast.next != null) {
            fast = fast.next.next; 
            slow = slow.next; 
        }
        
        return slow; 
    } 
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); 
        ListNode ite = dummy; 
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ite.next = l1; 
                l1 = l1.next; 
            } else {
                ite.next = l2; 
                l2 = l2.next; 
            }
            ite = ite.next; 
        }
        
        if (l1 == null) {
            ite.next = l2; 
        } else if (l2 == null) {
            ite.next = l1; 
        }
        
        return dummy.next; 
    }
     
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null) {
            return head; 
        }
        
        ListNode middle = findMiddle(head); 
        if (middle.next != null) {
            ListNode temp = middle.next; 
            ListNode head2 = sortList(temp); 
            middle.next = null; 
            ListNode head1 = sortList(head); 
            return merge(head1, head2); 
        } else {
            return head; 
        }
    }
}
