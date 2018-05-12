/**
93. Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

Solution: DFS. Obey some rules (1)0 <= sub <= 255 (2)0 can only be alone (3)sub can only be 1 to 3 digits (4)at most 3 dots. 
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>(); 
        if (s == null || s.length() < 4 || s.length() > 16) {
            return list; 
        }
        helper(list, s, "", 3, 0); 
        return list; 
    }
    
    private void helper(List<String> list, String s, String cur, int numOfDots, int idx) {
        if (numOfDots < 0) {
            return; 
        }
        if (idx == s.length() && numOfDots == 0) {
            list.add(cur); 
            return; 
        }
        for (int i = 1; i <= 3; i++) {
            if (idx + i > s.length()) {
                break; 
            }
            String sub = s.substring(idx, idx + i); 
            if (Integer.valueOf(sub) <= 255) {
                if (idx == 0) {
                    helper(list, s, cur + sub, numOfDots, idx + i); 
                } else {
                    helper(list, s, cur + "." + sub, numOfDots - 1, idx + i); 
                } 
            }
            if (Integer.valueOf(sub) == 0) {
                break;
            }
        }
    }
}