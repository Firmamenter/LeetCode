/**
146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

Solution: Two directional linked list. 
*/

class LRUCache {
    private int capacity; 
    private Map<Integer, ListNode> map; 
    private int tail; 
    private int head; 

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        map = new HashMap<Integer, ListNode>(); 
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; 
        }
        if (head == key) {
            return map.get(key).val; 
        }
        if (tail == key) {
            tail = map.get(tail).next.key; 
        }
        ListNode h = map.get(head); 
        ListNode cur = map.get(key); 
        ListNode curP = cur.pre; 
        ListNode curN = cur.next; 
        if (curP != null) {
            curP.next = curN; 
        }
        curN.pre = curP; 
        h.next = cur; 
        cur.pre = h; 
        cur.next = null; 
        head = key; 
        return cur.val; 
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            get(key); 
            map.get(key).val = value; 
            return; 
        }
        if (map.size() >= capacity) {
            ListNode tailN = map.get(tail).next; 
            map.remove(tail); 
            if (tailN != null) {
                tail = tailN.key; 
            }
        }
        ListNode newNode = new ListNode(key, value); 
        map.put(key, newNode); 
        if (map.size() == 1) {
            head = key; 
            tail = key; 
        } else {
            ListNode h = map.get(head); 
            newNode.pre = h; 
            h.next = newNode; 
            head = key; 
        }
    }
    
    private class ListNode {
        int key; 
        int val; 
        ListNode next; 
        ListNode pre; 
        ListNode(int key, int val) {
            this.key = key; 
            this.val = val; 
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */