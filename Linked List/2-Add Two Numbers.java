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
        int sum = 0; 
        ListNode head1 = l1; 
        ListNode head2 = l2; 
        while (true) {
            sum = head1.val + head2.val + carrier; 
            head1.val = sum % 10; 
            head2.val = sum % 10; 
            carrier = sum / 10; 
            if (head1.next == null && head2.next == null) {
                if (carrier == 1) {
                    ListNode tail = new ListNode(carrier); 
                    head1.next = tail; 
                }
                return l1; 
            } else if (head1.next == null || head2.next == null) {
                break; 
            } else {
                head1 = head1.next; 
                head2 = head2.next; 
            }
        }
        while (head1.next != null) {
            head1 = head1.next; 
            sum = head1.val + carrier; 
            head1.val = sum % 10; 
            carrier = sum / 10; 
            if (head1.next == null) {
                if (carrier == 1) {
                    ListNode tail = new ListNode(carrier); 
                    head1.next = tail; 
                }
                return l1; 
            }
        }
        while (head2.next != null) {
            head2 = head2.next; 
            sum = head2.val + carrier; 
            head2.val = sum % 10; 
            carrier = sum / 10; 
            if (head2.next == null) {
                if (carrier == 1) {
                    ListNode tail = new ListNode(carrier); 
                    head2.next = tail; 
                }
                return l2; 
            }
        }
        return l1; 
    }
}