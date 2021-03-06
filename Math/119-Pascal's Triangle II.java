/**
119. Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

Solution: Math.
*/

// Time: O(n^2)
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(); 
        if (rowIndex < 0) {
            return res; 
        }
        res.add(1); 
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0, 1); 
            for (int j = 1; j < i; j++) {
                res.set(j, res.get(j) + res.get(j + 1)); 
            }
        }
        return res; 
    }
}