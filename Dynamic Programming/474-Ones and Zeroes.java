/**
474. Ones and Zeroes

In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:
The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.
Example 1:
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
Example 2:
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

Solution: 类似于01背包问题. 背包问题其实就是如何利用有效资源获取最大利润的问题. 此题引出DP的两个新重要问题，Base case和general rule的关系，general rule更新的顺序.
*/

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || m < 0 || n < 0) return 0; 
        Map<String, int[]> map = new HashMap<>(); 
        for (String str : strs) {
            int count = 0; 
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') count++; 
            }
            int[] temp = {str.length() - count, count}; 
            map.put(str, temp); 
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1]; 
        for (int i = 1; i < dp.length; i++) {
            int[] temp = map.get(strs[i - 1]); 
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (temp[0] > j || temp[1] > k) dp[i][j][k] = dp[i - 1][j][k]; 
                    else dp[i][j][k] = Math.max(dp[i - 1][j - temp[0]][k - temp[1]] + 1, dp[i - 1][j][k]); 
                }
            }
        }
        return dp[strs.length][m][n]; 
    }
}

// 简化版
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || m < 0 || n < 0) return 0; 
        Map<String, int[]> map = new HashMap<>(); 
        for (String str : strs) {
            int count = 0; 
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') count++; 
            }
            int[] temp = {str.length() - count, count}; 
            map.put(str, temp); 
        }
        int[][] dp = new int[m + 1][n + 1]; 
        for (int i = 0; i < strs.length; i++) {
            int[] temp = map.get(strs[i]); 
            for (int j = m; j >= temp[0]; j--) {              // 从后往前更新，防止旧值被覆盖
                for (int k = n; k >= temp[1]; k--) {
                    dp[j][k] = Math.max(dp[j - temp[0]][k - temp[1]] + 1, dp[j][k]); 
                }
            }
        }
        return dp[m][n]; 
    }
}