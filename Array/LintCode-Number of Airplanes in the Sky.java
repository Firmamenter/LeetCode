/**
LintCode: Number of Airplanes in the Sky

Description
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?
If landing and flying happens at the same time, we consider landing should happen at first.
Have you met this question in a real interview?  Yes
Example
For interval list

[
  (1,10),
  (2,3),
  (5,8),
  (4,7)
]
Return 3

Sol: Sweep line. 
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    private class pair {
        int idx; 
        int flying; 
        pair(int idx, int flying) {
            this.idx = idx; 
            this.flying = flying; 
        }
    }
     
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0; 
        }
        List<pair> list = new ArrayList<>(); 
        for (Interval airplane : airplanes) {
            list.add(new pair(airplane.start, 1)); 
            list.add(new pair(airplane.end, 0)); 
        }
        Collections.sort(list, (a, b) -> 
        a.idx == b.idx ? a.flying - b.flying : a.idx - b.idx); 
        int cnt = 0; 
        int max = 0; 
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).flying == 0) {
                cnt--; 
            } else {
                cnt++; 
                max = Math.max(max, cnt); 
            }
        }
        return max; 
    }
}