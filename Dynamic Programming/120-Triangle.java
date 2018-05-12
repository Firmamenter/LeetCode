/**
120. Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Solution: Top down DP.
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0; 
        int[] dp = new int[triangle.get(triangle.size() - 1).size()]; 
        dp[0] = triangle.get(0).get(0); 
        for (int i = 1; i < triangle.size(); i++) {
            int len = triangle.get(i).size(); 
            for (int j = len - 1; j >= 0; j--) {
                if (j == 0) dp[j] += triangle.get(i).get(j); 
                else if (j == len - 1) dp[j] = dp[j - 1] + triangle.get(i).get(j); 
                else dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j); 
            }
        }
        int min = Integer.MAX_VALUE; 
        for (int num : dp) {
            min = Math.min(num, min); 
        }
        return min; 
    }
}

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0; 
        }
        List<List<Integer>> min = new ArrayList<>(); 
        List<Integer> level = new ArrayList<>(); 
        level.add(triangle.get(0).get(0)); 
        min.add(level); 
        for (int i = 1; i < triangle.size(); i++) {
            level = new ArrayList<>(); 
            int len = triangle.get(i).size(); 
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    level.add(min.get(i - 1).get(j) + triangle.get(i).get(j)); 
                } else if (j == len - 1) {
                    level.add(min.get(i - 1).get(j - 1) + triangle.get(i).get(j)); 
                } else {
                    level.add(Math.min(min.get(i - 1).get(j - 1), min.get(i - 1).get(j)) + triangle.get(i).get(j)); 
                }
            }
            min.add(level); 
        }
        int res = Integer.MAX_VALUE; 
        for (int k = 0; k < min.get(min.size() - 1).size(); k++) {
            if (res > min.get(min.size() - 1).get(k)) {
                res = min.get(min.size() - 1).get(k); 
            }
        }
        
        return res; 
    }
}