/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 0) {
            return false; 
        }
        
        Set<Character> tester = new HashSet<Character>(); 
        for (int i = 0; i < s.length(); i++) {
            if (tester.contains(s.charAt(i))) {
                tester.remove(s.charAt(i)); 
            } else {
                tester.add(s.charAt(i));
            }
        }
/*
        if (tester.size() > 1) {
            return false; 
        }
        return true;
*/
        return tester.size()==0 || tester.size()==1;
    }
}