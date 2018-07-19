/**
253. Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

Sol: Sweep line. 
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
    private class Pair {
        int idx; 
        int ending; 
        Pair(int idx, int ending) {
            this.idx = idx; 
            this.ending = ending; 
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0; 
        }
        List<Pair> list = new ArrayList<>(); 
        for (Interval interval : intervals) {
            list.add(new Pair(interval.start, 1)); 
            list.add(new Pair(interval.end, 0)); 
        } 
        Collections.sort(list, (a, b) -> a.idx == b.idx ? a.ending - b.ending : a.idx - b.idx); 
        int cnt = 0; 
        int maxMeetings = 0; 
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ending == 0) {
                cnt--; 
            } else {
                cnt++; 
                maxMeetings = Math.max(maxMeetings, cnt); 
            }
        }
        return maxMeetings; 
    }
}