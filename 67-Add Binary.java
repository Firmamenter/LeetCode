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