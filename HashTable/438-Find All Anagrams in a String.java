/**
438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Solution: Use hashTable to store the number of different characters in target string p and source string s, then compare them. If matched record index, otherwise sliding window.
*/

//Time O(n)(Because the size of hashTable is at most 26!!!)    Space O(1)
//Tricks: 1.Use Map.Entry to iterate map, instead of Entry.     2.Use equals to determine whether two Character varibales are equal.
//        3.Be careful about the time complexity, whenever you encounter a problem dealing with characters, you shall remember that there are at most 26 letters in English.
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>(); 
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return res; 
        }
        
        Map<Character, Integer> countP = new HashMap<>(); 
        for (int i = 0; i < p.length(); i++) {
            if (countP.containsKey(p.charAt(i))) {
                countP.put(p.charAt(i), countP.get(p.charAt(i)) + 1); 
            } else {
                countP.put(p.charAt(i), 1); 
            }
        }
        
        Map<Character, Integer> countS = new HashMap<>(); 
        for (int i = 0; i < p.length(); i++) {
            if (countS.containsKey(s.charAt(i))) {
                countS.put(s.charAt(i), countS.get(s.charAt(i)) + 1); 
            } else {
                countS.put(s.charAt(i), 1); 
            }
        }
        
        if (isEqual(countP, countS)) {
            res.add(0); 
        }
        
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (countS.get(s.charAt(i)) == 1) {
                countS.remove(s.charAt(i)); 
            } else {
                countS.put(s.charAt(i), countS.get(s.charAt(i)) - 1); 
            }
            if (!countS.containsKey(s.charAt(i + p.length()))) {
                countS.put(s.charAt(i + p.length()), 1); 
            } else {
                countS.put(s.charAt(i + p.length()), countS.get(s.charAt(i + p.length())) + 1); 
            }
            if (isEqual(countP, countS)) {
                res.add(i + 1); 
            }
        }
        
        return res; 
    }
    
    private boolean isEqual(Map<Character, Integer> countP, Map<Character, Integer> countS) {
        if (countP.size() != countS.size()) {
            return false; 
        }
        Set<Map.Entry<Character, Integer>> entry = countS.entrySet(); //Use Map.Entry instead of Entry
        for (Map.Entry<Character, Integer> e : entry) {
            if (!countP.containsKey(e.getKey())) {
                return false; 
            } else if (!countP.get(e.getKey()).equals(e.getValue())) { //Use equals instead of ==
                return false; 
            }
        }
        return true; 
    }
}