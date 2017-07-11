/**
160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

Solution: Linked List.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; 
        }
        ListNode iteA = headA; 
        ListNode iteB = headB; 
        int countA = 1; 
        int countB = 1; 
        while (iteA.next != null) {
            countA++; 
            iteA = iteA.next; 
        }
        while (iteB.next != null) {
            countB++; 
            iteB = iteB.next; 
        }
        if (iteA != iteB) {
            return null; 
        }
        iteA = headA; 
        iteB = headB; 
        while (countA > countB) {
            countA--; 
            iteA = iteA.next; 
        }
        while (countA < countB) {
            countB--; 
            iteB = iteB.next; 
        }
        while (iteA != iteB) {
            iteA = iteA.next; 
            iteB = iteB.next; 
        }
        
        return iteA; 
    }
}