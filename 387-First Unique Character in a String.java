/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
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
public static int firstUniqChar(String s) {
        char[] a = s.toCharArray();
        for(int i=0; i<a.length;i++){
            if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
        }
        return -1;
    }