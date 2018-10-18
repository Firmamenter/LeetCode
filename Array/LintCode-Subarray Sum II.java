/**
LintCode: Subarray Sum II

Given an integer array, find a subarray where the sum of numbers is in a given interval. Your code should return the number of possible answers. (The element in the array should be positive)

Sol: Binary search O(nlogn)
*/
public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    int find(int[] A, int len, int value) {
        if (len-1 >= 0 && A[len-1] < value )
            return len;
        
        int l = 0, r = len-1, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (value <= A[mid]) {
                ans = mid;
                r = mid - 1;
            }  else
                l = mid + 1;
        }
        return ans;
    }

    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int len = A.length;
        for (int i = 1; i <len; ++i)
            A[i] += A[i-1];

        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            if (A[i] >= start && A[i] <= end)
                cnt ++;
            int l = A[i] - end;
            int r = A[i] - start;
            cnt += find(A, i, r+1) - find(A, i, l); 
        }
        return cnt;
    }
}
