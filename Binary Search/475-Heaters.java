/**
475. Heaters

Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

Solution: Binary Search. 
*/

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0) {
            return 0; 
        }
        
        Arrays.sort(heaters); 
        int min = Integer.MIN_VALUE; 
        for (int house : houses) {
            int leftHeaterPos = helper(heaters, house); 
            int rightHeaterPos = leftHeaterPos + 1; 
            if (house > heaters[leftHeaterPos] && rightHeaterPos < heaters.length) {
                min = Math.max(min, Math.min(house - heaters[leftHeaterPos], heaters[rightHeaterPos] - house)); 
            } else {
                min = Math.max(min, Math.abs(house - heaters[leftHeaterPos])); 
            }
        }
        return min; 
    }
    
    private int helper(int[] heaters, int target) {
        int start = 0; 
        int end = heaters.length - 1; 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; 
            if (heaters[mid] == target) {
                return mid; 
            } else if (heaters[mid] > target) {
                end = mid; 
            } else {
                start = mid; 
            }
        }
        if (heaters[end] <= target) {
            return end; 
        } else {
            return start; 
        }
    }
}