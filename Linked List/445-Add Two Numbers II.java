/**
445. Add Two Numbers II

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

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
// Without reversing. 
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

// With reversing. 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1); 
        ListNode head2 = reverse(l2); 
        helper(head1, head2); 
        return reverse(head1); 
    }
    
    private ListNode reverse(ListNode l) {
        ListNode left = null; 
        ListNode mid = l; 
        ListNode right = l.next; 
        while (mid != null) {
            mid.next = left; 
            left = mid; 
            mid = right; 
            if (right == null) {
                break; 
            }
            right = right.next; 
        }
        return left; 
    }
    
    private void helper(ListNode head1, ListNode head2) {
        int carrier = 0; 
        ListNode behind1 = null; 
        ListNode behind2 = null; 
        while (head1 != null && head2 != null) {
            int sum = carrier + head1.val + head2.val; 
            head1.val = sum % 10; 
            carrier = sum / 10; 
            behind1 = head1; 
            behind2 = head2; 
            head1 = head1.next; 
            head2 = head2.next; 
        }
        while (head1 != null) {
            int sum = carrier + head1.val; 
            head1.val = sum % 10; 
            carrier = sum / 10; 
            behind1 = head1; 
            head1 = head1.next; 
        }
        if (head2 != null) {
            behind1.next = head2; 
        }
        while (head2 != null) {
            int sum = carrier + head2.val; 
            head2.val = sum % 10; 
            carrier = sum / 10; 
            behind1 = head2; 
            head2 = head2.next; 
        }
        if (carrier != 0) {
            ListNode head = new ListNode(carrier); 
            behind1.next = head; 
            behind1 = head; 
        }
    }
}