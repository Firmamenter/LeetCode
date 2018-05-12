/**
387. First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Solution: HashTable. indexOf() and lastIndexOf()
*/

/*************************** my solution ***************************/

public class Solution {
    public int firstUniqChar(String s) {
        if (s == null && s.length() == 0) {
            return -1; 
        }
        Map<Character, Integer> temp = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (temp.containsKey(s.charAt(i))) {
                temp.put(s.charAt(i), temp.get(s.charAt(i)) + 1); 
            } else {
                temp.put(s.charAt(i), 1);
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if (temp.get(s.charAt(j)) == 1) {
                return j; 
            }
        }
        return -1; 
    }
}

/*************************** better solution ***************************/
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1; 
        }
        int[][] record = new int[26][2]; 
        char[] charArray = s.toCharArray(); 
        for (int i = charArray.length - 1; i >= 0; i--) {
            record[charArray[i] - 'a'][0] += 1; 
            record[charArray[i] - 'a'][1] = i; 
        }
        int idx = Integer.MAX_VALUE; 
        for (int i = 0; i < record.length; i++) {
            if (record[i][0] == 1) {
                idx = Math.min(idx, record[i][1]); 
            }
        }
        return idx == Integer.MAX_VALUE ? -1 : idx; 
    }
}