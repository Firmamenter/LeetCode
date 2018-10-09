/**
681. Next Closest Time

Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

Sol: Simulation
*/

class Solution {
    public String nextClosestTime(String time) {
        int curTime = 60 * Integer.valueOf(time.substring(0, 2));
        curTime += Integer.valueOf(time.substring(3));
        Set<Integer> set = new HashSet();
        for (int i = 0; i < 5; i++) {
            if (i != 2) {
                set.add(time.charAt(i) - '0'); 
            }
        }

        String res = ""; 
        while (true) {
            curTime = (curTime + 1) % (24 * 60);
            int[] digits = {curTime / 60 / 10, curTime / 60 % 10, curTime % 60 / 10, curTime % 60 % 10};
            if (isValid(set, digits)) {   
                res = String.format("%02d:%02d", curTime / 60, curTime % 60); 
                break; 
            }
        }
        return res; 
    }
    
    private boolean isValid(Set<Integer> set, int[] digits) {
        for (int digit : digits) {
            if (!set.contains(digit)) {
                return false; 
            }
        }
        return true; 
    }
}