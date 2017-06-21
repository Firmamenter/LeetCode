/**
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Example
Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

Solution: Max heap.
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
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    PriorityQueue<ListNode> pq;  
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null; 
        }
        pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val; 
            }
        }); 
        
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                pq.offer(lists.get(i)); 
            }
        }
        
        if (pq.isEmpty()) {
            return null; 
        }
        
        ListNode root = pq.poll(); 
        ListNode head = root; 
        
        if (root.next != null) {
            pq.offer(root.next); 
        }
        
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll(); 
            if (temp.next != null) {
                pq.offer(temp.next); 
            }
            head.next = temp; 
            head = head.next; 
        }
        
        return root; 
    }
}
