/**
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Solution: HashTable.
*/


#1
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                if ((char)map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (map.values().contains(t.charAt(i))) {
                return false; 
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true; 
    }
}

#2
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }
        }
        return true;
        
    }
}