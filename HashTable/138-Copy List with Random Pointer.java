/**
138. Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Solution: Use HashMap to store the mapping relationship between original RandomListNode and new RandomListNode.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

//Time: O(n)    Space: O(n)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head; 
        }
        
        RandomListNode ite = head; 
        RandomListNode cur = new RandomListNode(ite.label); 
        RandomListNode pre = cur; 
        
        Map<RandomListNode, RandomListNode> mapping = new HashMap<>(); 
        mapping.put(ite, cur); 
        ite = ite.next; 
        
        while (ite != null) {
            cur = new RandomListNode(ite.label); 
            mapping.put(ite, cur); 
            pre.next = cur; 
            pre = cur; 
            ite = ite.next; 
        }
        
        ite = head; 
        while (ite != null) {
            if (ite.random != null) {
                mapping.get(ite).random = mapping.get(ite.random); 
            }
            ite = ite.next; 
        }
        
        return mapping.get(head); 
    }
}

//Improved version: Time O(n)   Space O(1)
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head; 
        }
        
        RandomListNode ite = head; 
        RandomListNode dup; 
        while (ite != null) {                       //A -> a -> B -> b -> C -> c
            dup = new RandomListNode(ite.label); 
            dup.next = ite.next; 
            ite.next = dup; 
            ite = dup.next; 
        }
        
        ite = head; 
        while (ite != null) {
            dup = ite.next; 
            if (ite.random != null) {
                dup.random = ite.random.next; 
            } else {
                dup.random = null; 
            }
            ite = dup.next; 
        }
        
        ite = head; 
        RandomListNode root = head.next; 
        while (ite != null) {
            dup = ite.next; 
            ite.next = dup.next; 
            if (ite.next != null) {
                dup.next = dup.next.next; 
            } else {
                dup.next = null; 
            }
            ite = ite.next; 
        }
        
        return root; 
    }
}