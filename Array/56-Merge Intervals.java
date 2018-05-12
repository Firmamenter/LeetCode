/**
56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Solution: Sorting. 
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals; 
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start); 
        List<Interval> res = new ArrayList<>(); 
        res.add(intervals.get(0)); 
        for (int idx = 1; idx < intervals.size(); idx++) {
            if (res.get(res.size() - 1).end < intervals.get(idx).start) {
                res.add(intervals.get(idx)); 
            } else {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(idx).end); 
            }
        }
        return res; 
    }
}