/**
215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ? k ? array's length.

Solution: Sorting O(nlogn). Min heap O(nlogk). Quick selection O(n) best O(n^2) worst. 
*/

// Sorting, O(nlogn)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums); 
        return nums[nums.length - k]; 
    }
}

// Min heap, O(nlogk)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b); 
        for (int num : nums) {
            minHeap.offer(num); 
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        return minHeap.peek(); 
    }
}

// Quick selection, O(n)
