/**
445. Add Two Numbers II

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

SOlution: LinkedList. 
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
        Stack<Integer> stack1 = new Stack<>(); 
        Stack<Integer> stack2 = new Stack<>(); 
        ListNode head1 = l1; 
        ListNode head2 = l2; 
        while (head1 != null) {
            stack1.push(head1.val); 
            head1 = head1.next; 
        }
        while (head2 != null) {
            stack2.push(head2.val); 
            head2 = head2.next; 
        }
        int carrier = 0; 
        int sum = 0; 
        ListNode head = new ListNode(0); 
        while (!stack1.empty() && !stack2.empty()) {
            sum = carrier + stack1.pop() + stack2.pop(); 
            carrier = sum / 10; 
            ListNode ln = new ListNode(sum % 10); 
            ln.next = head.next; 
            head.next = ln; 
        }
        while (!stack1.empty()) {
            sum = carrier + stack1.pop(); 
            carrier = sum / 10; 
            ListNode ln = new ListNode(sum % 10); 
            ln.next = head.next; 
            head.next = ln; 
        }
        while (!stack2.empty()) {
            sum = carrier + stack2.pop(); 
            carrier = sum / 10; 
            ListNode ln = new ListNode(sum % 10); 
            ln.next = head.next; 
            head.next = ln; 
        }
        if (carrier == 1) {
            ListNode ln = new ListNode(carrier); 
            ln.next = head.next; 
            head.next = ln; 
        }
        return head.next; 
    }
}