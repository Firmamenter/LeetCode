/**
295. Find Median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

Solution: Using two heaps. 
*/

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; 
    private PriorityQueue<Integer> minHeap; 

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a); 
        minHeap = new PriorityQueue<Integer>((a, b) -> a - b); 
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty()) maxHeap.offer(num); 
        else if (maxHeap.peek() >= num) maxHeap.offer(num); 
        else minHeap.offer(num); 
        if (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll()); 
        else if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll()); 
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) return (double)maxHeap.peek(); 
        else return (minHeap.peek() + maxHeap.peek()) / 2.0; 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */