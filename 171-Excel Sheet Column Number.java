public class Solution {
    public int titleToNumber(String s) {
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('A' > s.charAt(i) || s.charAt(i) > 'Z') {
                return 0;
            } else {
                result = s.charAt(i) - 'A' + 1 + result * 26;
            }
        }
        return result; 
    }
}