/**
125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Solution: Two pointers. 1) Character.isLetterOrDigit(s.charAt(i)). 2) 'a' <= s.charAt(i) && s.charAt(i) <= 'z'.
*/

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false; 
        }
        int len = s.length(); 
        if (len == 0 || len == 1) {
            return true; 
        }
        s = s.toLowerCase(); 
        int left = 0; 
        int right = len - 1; 
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++; 
            }
            while (right > left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--; 
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++; 
                right--; 
            } else {
                return false;
            }
        }
        return true; 
    }
}

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


public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true; 
        }
        
        int i = 0; 
        int j = s.length() - 1; 
        while(i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++; 
                continue; 
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--; 
                continue; 
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false; 
            } else {
                i++; 
                j--; 
            }
        }
        
        return true;
    }
}
