/**
453. Minimum Moves to Equal Array Elements

Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

Solution: Math. Every step can be divided into two individual steps: add 1 to all columns and then choose one column to minus one. So the result should be sum - min * array.length. 
*/

public class Solution {
    public int minMoves(int[] nums) {
        int sum = 0; 
        int min = Integer.MAX_VALUE; 
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            min = Math.min(min, nums[i]); 
        }
        return sum - min * nums.length; 
    }
}