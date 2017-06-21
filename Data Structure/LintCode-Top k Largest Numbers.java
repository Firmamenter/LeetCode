/**
LintCode: Top k Largest Numbers

Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].

Solution: Sorting or max heap. 
*/

//Sorting
//Time O(nlogn)
class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if (nums == null) {
            return null; 
        }
        
        Arrays.sort(nums); 
        
        int topk[]; 
        if (k < nums.length) {
            topk = new int[k]; 
        } else {
            topk = new int[nums.length]; 
        }
        
        for (int i = 0; i < k; i++) {
            if (nums.length - i - 1 >= 0) {
                topk[i] = nums[nums.length - i - 1]; 
            }
        }
        
        return topk; 
    }
}

//Max Heap
//Time O(nlogk)
import java.util.PriorityQueue;

class Test {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if (nums == null) {
            return null;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (a, b) -> a - b);

        int len = nums.length;
        int[] res;
        res = (k < len) ? new int[k] : new int[len];

        for (int i = 0; i < len; i++) {
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for (int j = 0; j < k; j++) {
            if (res.length - j - 1 >= 0) {
                res[res.length - j - 1] = maxHeap.poll();
            }
        }

        return res;
    }
}



