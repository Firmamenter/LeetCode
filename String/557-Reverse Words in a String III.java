/**
557. Reverse Words in a String III

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

Solution: StringBuilder.
*/

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" "); 
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString(); 
        }
        String result = words[0]; 
        for (int i = 1; i < words.length; i++) {
            result = result + " " + words[i]; 
        }
        return result; 
    }
}