/**
LintCode: Merge k Sorted Arrays

Given k sorted integer arrays, merge them into one sorted array.

Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

Solution: Use min heap.
*/

//Do it in O(N log k).
//N is the total number of integers.
//k is the number of arrays.

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    private class Tuple {
        int val; 
        int row; 
        int col; 
        Tuple (int val, int row, int col) {
            this.val = val; 
            this.row = row; 
            this.col = col; 
        }
    } 
    
    private PriorityQueue<Tuple> pq; 
    
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> res = new ArrayList<>(); 
        if (arrays == null || arrays.length == 0) {
            return res; 
        }
        pq = new PriorityQueue<Tuple>(arrays.length, new Comparator<Tuple>() {
            public int compare(Tuple a, Tuple b) {
                return a.val - b.val; 
            }
        }); 
        
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 0) {
                Tuple temp = new Tuple(arrays[i][0], i, 0); 
                pq.offer(temp); 
            }
        }
        
        int count = 0; 
        for (int j = 0; j < arrays.length; j++) {
            count += arrays[j].length; 
        }
        
        while (res.size() < count) {
            Tuple out = pq.poll(); 
            res.add(out.val); 
            if (arrays[out.row].length - 1 > out.col) {
                Tuple in = new Tuple(arrays[out.row][out.col + 1], out.row, out.col + 1); 
                pq.offer(in); 
            }
        }
        
        return res; 
    }
}