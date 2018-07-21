/**
LintCode: Stone Game

There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Sol: DP. 
*/

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public static int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        // status
        int[][] f = new int[n][n];

        // initialize
        for (int i = 0; i < n; i++) {
            f[i][i] = 0;
        }

        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        for (int delta = 1; delta < n; delta++) {
            for (int i = 0; i + delta < n; i++) {
                int j = i + delta;
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + sum[i][j]);
                }
            }
        }

        return f[0][n - 1];
  }  
}