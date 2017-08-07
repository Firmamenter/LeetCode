/**
LintCode: Sort Letters by Case

Given a string which contains only letters. Sort it by lower case first and upper case second.

 Notice

It's NOT necessary to keep the original order of lower-case letters and upper case letters.

Have you met this question in a real interview? Yes
Example
For "abAcD", a reasonable answer is "acbAD"

Solution: Two pointers. 
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int left = 0; 
        int right = chars.length - 1; 
        while (left < right) {
            while (left < chars.length && chars[left] >= 'a' && chars[left] <= 'z') {
                left++; 
            }
            while (right >= 0 && chars[right] >= 'A' && chars[right] <= 'Z') {
                right--; 
            }
            if (left < right) {
                char temp = chars[left]; 
                chars[left] = chars[right]; 
                chars[right] = temp; 
                left++; 
                right--; 
            }
        }
    }
}
