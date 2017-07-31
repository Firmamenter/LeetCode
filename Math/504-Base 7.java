/**
504. Base 7

Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].

Solution: Math. 
*/

public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0"; 
        }
        StringBuilder res = new StringBuilder(); 
        int temp = Math.abs(num); 
        while (temp != 0) {
            res.append(temp % 7); 
            temp /= 7; 
        }
        if (num < 0) {
            res.append("-"); 
        }
        return res.reverse().toString(); 
    }
}