/**
264. Ugly Number II

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

Solution: Math.
*/

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1; 
        }
        int idx2 = 0; 
        int idx3 = 0; 
        int idx5 = 0; 
        List<Integer> res = new ArrayList<>(); 
        res.add(1); 
        
        for (int i = 1; i < n; i++) {
            int last = res.get(i - 1); 
            while (res.get(idx2) * 2 <= last) {
                idx2++; 
            }
            while (res.get(idx3) * 3 <= last) {
                idx3++; 
            }
            while (res.get(idx5) * 5 <= last) {
                idx5++; 
            }
            
            res.add(Math.min(res.get(idx2) * 2, Math.min(res.get(idx3) * 3, res.get(idx5) * 5))); 
        } 
        return res.get(n - 1); 
    }
}