/**
LintCode: Top k Largest Numbers II 

Implement a data structure, provide two interfaces:

add(number). Add a new number in the data structure.
topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.

Solution: Max Heap + sort.
*/

public class Solution {
    PriorityQueue<Integer> maxHeap;  
    private int size; 

    public Solution(int k) {
        // initialize your data structure here.
        maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b; 
            }
        }); 
        size = k; 
    }

    public void add(int num) {
        // Write your code here
        maxHeap.offer(num); 
        if (maxHeap.size() > size) {
            maxHeap.poll(); 
        }
        
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> res = new ArrayList<>(); 
        Iterator ite = maxHeap.iterator(); 
        while (ite.hasNext()) {
            res.add((int)ite.next()); 
        }
        Collections.sort(res, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a; 
            }
        }); 
        return res; 
    }
}