/**
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Solution: LinkedList. 
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carrier = 0; 
        ListNode root = new ListNode(0); 
        ListNode head = root; 
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carrier; 
            carrier = sum / 10; 
            ListNode newNode = new ListNode(sum % 10); 
            head.next = newNode; 
            head = head.next; 
            l1 = l1.next; 
            l2 = l2.next; 
        }
        while (l1 != null) {
            int sum = l1.val + carrier; 
            carrier = sum / 10; 
            ListNode newNode = new ListNode(sum % 10); 
            head.next = newNode; 
            head = head.next; 
            l1 = l1.next; 
        }
        while (l2 != null) {
            int sum = l2.val + carrier; 
            carrier = sum / 10; 
            ListNode newNode = new ListNode(sum % 10); 
            head.next = newNode; 
            head = head.next; 
            l2 = l2.next; 
        }
        if (carrier != 0) {
            ListNode newNode = new ListNode(carrier); 
            head.next = newNode; 
        }
        return root.next; 
    }
}