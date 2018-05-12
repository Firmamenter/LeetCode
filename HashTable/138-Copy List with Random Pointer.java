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
            return null; 
        }
        Map<RandomListNode, RandomListNode> match = new HashMap<>(); 
        RandomListNode root = new RandomListNode(head.label); 
        RandomListNode newRoot = root; 
        RandomListNode newHead = head; 
        match.put(head, root); 
        newHead = newHead.next; 
        while (newHead != null) {
            RandomListNode newListNode = new RandomListNode(newHead.label); 
            match.put(newHead, newListNode); 
            newRoot.next = newListNode; 
            newRoot = newListNode; 
            newHead = newHead.next; 
        }
        newRoot = root; 
        newHead = head; 
        while (newHead != null) {
            newRoot.random = match.get(newHead.random); 
            newRoot = newRoot.next; 
            newHead = newHead.next; 
        }
        return root; 
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
            return null; 
        }
        RandomListNode newHead = head; 
        while (newHead != null) {         // A -> a -> B -> b -> C -> c
            RandomListNode newNode = new RandomListNode(newHead.label); 
            newNode.next = newHead.next; 
            newHead.next = newNode; 
            newHead = newNode.next; 
        }
        newHead = head; 
        while (newHead != null) {
            if (newHead.random != null) {
                newHead.next.random = newHead.random.next; 
            }
            newHead = newHead.next.next; 
        }
        newHead = head; 
        RandomListNode root = head.next; 
        RandomListNode newRoot = root; 
        while (newHead != null) {
            newHead.next = newHead.next.next; 
            newHead = newHead.next; 
            if (newHead == null) {
                break; 
            }
            newRoot.next = newRoot.next.next; 
            newRoot = newRoot.next; 
        }
        return root; 
    }
}