/**
LintCode: Data Stream Median

Numbers keep coming, return the median of numbers at every time a new number added.

Clarification
What's the definition of Median?
- Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

Solution: Use min heap and max heap.
*/

//Time: O(nlogn)
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    private PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return b - a; 
        }
    }); 
    private PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return a - b; 
        }
    }); 
    
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null; 
        }
        
        int[] res = new int[nums.length]; 
        int media = nums[0]; 
        res[0] = media; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= media) {
                if (min.size() == max.size()) {
                    max.offer(nums[i]); 
                    res[i] = media; 
                } else {
                    min.offer(media); 
                    max.offer(nums[i]); 
                    media = max.poll(); 
                    res[i] = media; 
                }
            } else {
                if (min.size() == max.size()) {
                    max.offer(media); 
                    min.offer(nums[i]); 
                    media = min.poll(); 
                    res[i] = media; 
                } else {
                    min.offer(nums[i]); 
                    res[i] = media; 
                }
            }
        }
        
        return res; 
        
    }
}