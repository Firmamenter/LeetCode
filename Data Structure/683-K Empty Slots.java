/**
683. K Empty Slots

There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.
Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1
Note:
The given array will be in the range [1, 20000].

Sol: TreeSet, Sliding window
*/

// TreeSet O(NlogN) time and O(N) space
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if (k < 0) {
            return -1; 
        }
        TreeSet<Integer> treeset = new TreeSet<>(); 
        for (int i = 0; i < flowers.length; i++) {
            int pos = flowers[i]; 
            treeset.add(pos); 
            Integer left = treeset.lower(pos); 
            Integer right = treeset.higher(pos); 
            if (i != 0 && (left != null && pos - left - 1 == k || right != null && right - pos - 1 == k)) {
                return i + 1; 
            }
        }
        return -1; 
    }
}

// Sliding window O(N) time and O(1) space
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if (k < 0) {
            return -1; 
        }
        int[] dates = new int[flowers.length]; 
        for (int i = 0; i < flowers.length; i++) {
            dates[flowers[i] - 1] = i + 1; 
        }
        
        int min = Integer.MAX_VALUE; 
        int left = 0; 
        int right = k + 1; 
        while (right < dates.length) {
            int invalidFlower = findInvalidFlower(dates, left, right); 
            if (invalidFlower == -1) {
                min = Math.min(min, Math.max(dates[left], dates[right])); 
                left = right; 
            } else {
                left = invalidFlower; 
            }
            right = left + k + 1; 
        }
        return min == Integer.MAX_VALUE ? -1 : min; 
    }
    
    private int findInvalidFlower(int[] dates, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            if (dates[i] < dates[left] || dates[i] < dates[right]) {
                return i; 
            }
        }
        return -1; 
    }
}

