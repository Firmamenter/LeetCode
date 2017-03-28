/**
506. Relative Ranks

Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.

Solution: Collections.sort(res, (a, b) -> b.get(0) - a.get(0))
*/

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        String[] result = new String[nums.length]; 
        int i = 0; 
        for (; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<Integer>(); 
            temp.add(nums[i]); 
            temp.add(i); 
            res.add(temp); 
        }
        Collections.sort(res, (a, b) -> b.get(0) - a.get(0)); 
        i = 0; 
        for (; i < res.size(); i++) {
            if (i == 0) {
                result[res.get(i).get(1)] = "Gold Medal"; 
            } else if (i == 1) {
                result[res.get(i).get(1)] = "Silver Medal";
            } else if (i == 2) {
                result[res.get(i).get(1)] = "Bronze Medal";
            } else {
                result[res.get(i).get(1)] = Integer.toString(i + 1);
            }
        }
        return result; 
    }
}