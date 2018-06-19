/**
350. Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

Solution: HashMap.
Follow-up: 1.Two pointers 只用存结果的空间 2.小的array放进HashMap里 3.同2
*/
// Time O(m + n)    Space O(m + n)
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0]; 
        }
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1); 
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1); 
            }
        }
        List<Integer> list = new ArrayList<>(); 
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) != 0) {
                list.add(nums2[j]); 
                map.put(nums2[j], map.get(nums2[j]) - 1); 
            }
        }
        int[] res = new int[list.size()]; 
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i); 
        }
        return res; 
    }
}