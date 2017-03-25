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