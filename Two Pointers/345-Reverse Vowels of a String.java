/**
345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

Solution: Two Pointer. 
*/

public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s; 
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        StringBuilder res = new StringBuilder(s); 
        int left = 0; 
        int right = s.length() - 1; 
        while (left < right) {
            if (!vowels.contains(res.charAt(left))) {
                left++; 
                continue; 
            }
            if (!vowels.contains(res.charAt(right))) {
                right--; 
                continue; 
            }
            char temp = res.charAt(right); 
            res.setCharAt(right, res.charAt(left)); 
            res.setCharAt(left, temp); 
            left++; 
            right--; 
        }
        return res.toString(); 
    }
}