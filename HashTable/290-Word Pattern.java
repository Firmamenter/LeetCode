/**
290. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

Solution: HashTable.
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        int len_p = pattern.length(); 
        
        Map<Character, String> match_table = new HashMap<Character, String>(); 
        
        String[] str_word = str.split(" "); 
        
        if (len_p != str_word.length) {
            return false;
        }
        
        for (int i = 0; i < len_p; i++) {
            if (!match_table.containsKey(pattern.charAt(i))) {
                if (match_table.containsValue(str_word[i])) {
                    return false;
                } else {
                    match_table.put(pattern.charAt(i), str_word[i]);
                }
            } else if (!match_table.get(pattern.charAt(i)).equals(str_word[i])) {
                return false; 
            }
        }
        return true;
    }
}