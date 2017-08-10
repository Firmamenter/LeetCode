/**
LintCode: Product of Array Exclude Itself

Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.

Have you met this question in a real interview? Yes
Example
For A = [1, 2, 3], return [6, 3, 2].

Solution: Forward-Backward Traversal. 
*/

public class Solution {
    /*
     * @param : Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> res = new ArrayList<>(); 
        if (nums.size() == 1) {
            res.add((long)1); 
            return res; 
        }
        int len = nums.size(); 
        long[] left = new long[len]; 
        long[] right = new long[len]; 
        left[0] = nums.get(0); 
        right[len - 1] = nums.get(len - 1); 
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums.get(i); 
            right[len - 1 - i] = right[len - i] * nums.get(len - 1 - i); 
        }
        res.add(right[1]); 
        for (int i = 1; i < len - 1; i++) {
            res.add(left[i - 1] * right[i + 1]); 
        }
        res.add(left[len - 2]); 
        return res; 
    }
};