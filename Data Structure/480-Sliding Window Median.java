/**
480. Sliding Window Median

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.

Sol: 特别注意第二种方法中的Comparator写法. 
*/
// Insertsion Sort. O(nk)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1]; 
        long[] arr = new long[k]; 
        for (int i = 0; i < k; i++) {
            arr[i] = nums[i]; 
        }
        Arrays.sort(arr); 
        res[0] = k % 2 == 0 ? (arr[k / 2 - 1] + arr[k / 2]) / 2.0 : arr[k / 2]; 
        for (int i = 1; i <= nums.length - k; i++) {
            insertAndDelete(nums, i, k, arr); 
            res[i] = k % 2 == 0 ? (arr[k / 2 - 1] + arr[k / 2]) / 2.0 : arr[k / 2]; 
        }
        return res; 
    }
    
    private void insertAndDelete(int[] nums, int i, int k, long[] arr) {
        int target = nums[i - 1]; 
        int newElement = nums[i + k - 1]; 
        int idx = 0; 
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == target) {
                idx = j; 
                break; 
            }
        }
        for (int j = idx; j < arr.length - 1; j++) {
            arr[j] = arr[j + 1]; 
        }
        for (int j = 0; j < arr.length; j++) {
            if (j == arr.length - 1) {
                idx = arr.length - 1; 
            }
            if (arr[j] > newElement) {
                idx = j; 
                break; 
            }
        }
        for (int j = arr.length - 1; j > idx; j--) {
            arr[j] = arr[j - 1]; 
        }
        arr[idx] = newElement; 
    }
}

// Heap. O(nk) 
class Solution {
    private PriorityQueue<Integer> minHeap; 
    private PriorityQueue<Integer> maxHeap; 
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        minHeap = new PriorityQueue<Integer>(k); 
        maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder()); 
        double[] res = new double[nums.length - k + 1]; 
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                insert(nums, i, k, minHeap, maxHeap); 
            } else {
                insert(nums, i, k, minHeap, maxHeap); 
                delete(nums, i, k, minHeap, maxHeap); 
            }
            if (i >= k - 1) {
                res[i - k + 1] = k % 2 == 0 ? ((long)minHeap.peek() + (long)maxHeap.peek()) / 2.0 : maxHeap.peek(); 
            }
        }
        return res; 
    }
    
    private void insert(int[] nums, int i, int k, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(nums[i]); 
            return; 
        }
        if (nums[i] <= maxHeap.peek()) {
            maxHeap.offer(nums[i]); 
        } else {
            minHeap.offer(nums[i]); 
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); 
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll()); 
        }
    }
    
    private void delete(int[] nums, int i, int k, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        int target = nums[i - k]; 
        if (minHeap.contains(target)) {
            minHeap.remove(target); 
        } else {
            maxHeap.remove(target); 
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); 
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll()); 
        }
    }
}

// TreeMap. O(nlogk)
class Solution {
    private TreeMap<Integer, Integer> minHeap; 
    private TreeMap<Integer, Integer> maxHeap; 
    private int minSize; 
    private int maxSize; 
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        minHeap = new TreeMap<Integer, Integer>(); 
        maxHeap = new TreeMap<Integer, Integer>(); 
        minSize = 0;
        maxSize = 0; 
        double[] res = new double[nums.length - k + 1]; 
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                insert(nums, i, k); 
            } else {
                insert(nums, i, k); 
                delete(nums, i, k); 
            }
            if (i >= k - 1) {
                res[i - k + 1] = k % 2 == 0 ? ((long)minHeap.firstKey() + (long)maxHeap.lastKey()) / 2.0 : maxHeap.lastKey(); 
            }
        }
        return res; 
    }
    
    private void insert(int[] nums, int i, int k) {
        if (maxHeap.size() == 0) {
            maxHeap.put(nums[i], 1); 
            maxSize++;  
            return; 
        }
        if (nums[i] <= maxHeap.lastKey()) {
            maxHeap.put(nums[i], maxHeap.getOrDefault(nums[i], 0) + 1); 
            maxSize++; 
        } else {
            minHeap.put(nums[i], minHeap.getOrDefault(nums[i], 0) + 1); 
            minSize++; 
        }
        if (maxSize > minSize + 1) {
            int key = maxHeap.lastKey(); 
            if (maxHeap.get(key) == 1) {
                maxHeap.remove(key); 
            } else {
                maxHeap.put(key, maxHeap.get(key) - 1); 
            }
            minHeap.put(key, minHeap.getOrDefault(key, 0) + 1); 
            maxSize--; 
            minSize++; 
        } else if (maxSize < minSize) {
            int key = minHeap.firstKey(); 
            if (minHeap.get(key) == 1) {
                minHeap.remove(key); 
            } else {
                minHeap.put(key, minHeap.get(key) - 1); 
            }
            maxHeap.put(key, maxHeap.getOrDefault(key, 0) + 1); 
            minSize--; 
            maxSize++; 
        }
    }
    
    private void delete(int[] nums, int i, int k) {
        int target = nums[i - k]; 
        if (minHeap.containsKey(target)) {
            if (minHeap.get(target) == 1) {
                minHeap.remove(target); 
            } else {
                minHeap.put(target, minHeap.get(target) - 1); 
            }
            minSize--; 
        } else {
            if (maxHeap.get(target) == 1) {
                maxHeap.remove(target); 
            } else {
                maxHeap.put(target, maxHeap.get(target) - 1); 
            }
            maxSize--; 
        }
        if (maxSize > minSize + 1) {
            int key = maxHeap.lastKey(); 
            if (maxHeap.get(key) == 1) {
                maxHeap.remove(key); 
            } else {
                maxHeap.put(key, maxHeap.get(key) - 1); 
            }
            minHeap.put(key, minHeap.getOrDefault(key, 0) + 1); 
            maxSize--; 
            minSize++; 
        } else if (maxSize < minSize) {
            int key = minHeap.firstKey(); 
            if (minHeap.get(key) == 1) {
                minHeap.remove(key); 
            } else {
                minHeap.put(key, minHeap.get(key) - 1); 
            }
            maxHeap.put(key, maxHeap.getOrDefault(key, 0) + 1); 
            minSize--; 
            maxSize++; 
        }
    }
}