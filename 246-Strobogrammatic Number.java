/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        //0 1 6 9 8
        Map stro = new HashMap(); 
        stro.put('0', '0'); 
        stro.put('1', '1'); 
        stro.put('6', '9');
        stro.put('8', '8'); 
        stro.put('9', '6'); 
        
        if (num.length() == 0) {
            return false; 
        }
        int left = 0; 
        int right = num.length() - 1; 
        while (left <= right) {
            if (stro.containsKey(num.charAt(left)) && (num.charAt(right) == (char)stro.get(num.charAt(left)))) {
                left += 1; 
                right -= 1; 
            } else {
                return false; 
            }
        }
        return true; 
    }
}