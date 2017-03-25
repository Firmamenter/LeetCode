public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true; 
        }
        
        s = s.toLowerCase(); 
        
        int i = 0; 
        int j = s.length() - 1; 
        while(i <= j) {
            if ( !('a' <= s.charAt(i) && s.charAt(i) <= 'z') && !('0' <= s.charAt(i) && s.charAt(i) <= '9')) {
                i++; 
                continue; 
            }
            if (!('a' <= s.charAt(j) && s.charAt(j) <= 'z') && !('0' <= s.charAt(j) && s.charAt(j) <= '9')) {
                j--; 
                continue; 
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false; 
            } else {
                i++; 
                j--; 
            }
        }
        
        return true;
    }
}