/**
LintCode: Coins in a Line

There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.

Could you please decide the first play will win or lose?

Solution: Math. 
*/

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n <= 0) {
            return false; 
        } else if (n % 3 == 0) {
            return false; 
        } else {
            return true; 
        }
    }
}