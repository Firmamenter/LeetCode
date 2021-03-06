/**
67. Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Solution: Use carrier to emulate bianry operation. For k based addition operation, the rule is to add two digits and 
          the carrier. Then the summation is divided by k to obtain the carrier and summation mod k to get the result for
          that digit.
          K based addition, the carrier is always no larger than k-1.
*/

public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return null; 
        }
        
        int sum = 0;
        int carrier = 0; 
        StringBuilder result = new StringBuilder(); 
        int i = 0; 
        for (; i < a.length() && i < b.length(); i++) {
            sum = (a.charAt(a.length() - 1 - i) - '0') + (b.charAt(b.length() - 1 - i) - '0') + carrier; 
            carrier = sum / 2; 
            result.insert(0, sum % 2); 
        }
        
        while (i < a.length()) {
            sum = (a.charAt(a.length() - 1 - i) - '0') + carrier; 
            carrier = sum / 2; 
            result.insert(0, sum % 2); 
            i++; 
        }
        
        while (i < b.length()) {
            sum = (b.charAt(b.length() - 1 - i) - '0') + carrier; 
            carrier = sum / 2; 
            result.insert(0, sum % 2); 
            i++;
        }
        
        if (carrier != 0) {
            result.insert(0, carrier);
        }
        
        return result.toString();
    }
}
