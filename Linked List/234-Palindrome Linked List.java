/**
234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

Solution: Reverse linkedlist from end to mid.
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true; 
        }
        ListNode tail = head; 
        int count = 1; 
        while (tail.next != null) {
            count++; 
            tail = tail.next; 
        }
        ListNode mid = head; 
        for (int i = 0; i < count / 2; i++) {
            mid = mid.next; 
        }
        ListNode pre = null; 
        ListNode cur = mid; 
        ListNode fore = mid.next; 
        while (cur != null) {
            cur.next = pre; 
            pre = cur; 
            cur = fore; 
            if (fore != null) {
                fore = fore.next; 
            }
        }
        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false; 
            }
            head = head.next; 
            tail = tail.next; 
        }
        return true; 
    }
}