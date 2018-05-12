/**
464. Can I Win

In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.

Solution: Recursion + memorization. 
*/
// 时间复杂度，如果不用Memorization则是O(n!)，用了Memorization则是O(2^n)
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false; 
        if (maxChoosableInteger >= desiredTotal) return true; 
        int[] used = new int[maxChoosableInteger]; 
        Map<String, Boolean> map = new HashMap<>(); 
        return helper(used, map, desiredTotal); 
    }
    
    private boolean helper(int[] used, Map<String, Boolean> map, int total) {
        String key = Arrays.toString(used); 
        if (map.containsKey(key)) return map.get(key); 
        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) {
                used[i] = 1; 
                if (i + 1 >= total || !helper(used, map, total - i - 1)) { // 核心，只要有一个选择是对手必输的，那么我就赢了
                    map.put(key, true); 
                    used[i] = 0; 
                    return true; 
                }
                used[i] = 0; 
            }
        }
        map.put(key, false); 
        return false; 
    }
}