/**
344. Reverse String

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Solution: StringBuilder, toCharArray.
*/

// StringBuilder.
public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s; 
        }
        
        return new StringBuilder(s).reverse().toString(); 
    }
}

// toCharArray().
public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s; 
        }
        
        char[] sChar = s.toCharArray(); 
        int left = 0; 
        int right = s.length() - 1; 
        while (left < right) {
            char temp = sChar[left]; 
            sChar[left] = sChar[right]; 
            sChar[right] = temp; 
            left++; 
            right--; 
        }
        return new String(sChar); 
    }
}

// Will exceed time limit.
public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s; 
        }
        
        String res = ""; 
        for (int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i) + ""; 
        }
        return res; 
    }
}