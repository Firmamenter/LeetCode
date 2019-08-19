/**
227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

Sol: 
*/

class Solution {
    public int calculate(String s) {
        // Define result, index, and preNum
        int res = 0; 
        int idx = 0; 
        int preNum = 0; 
        
        // Get the first number
        s = s.trim(); 
        StringBuilder firstNumString = new StringBuilder(); 
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            firstNumString.append(s.charAt(idx++)); 
        }
        preNum = Integer.valueOf(firstNumString.toString()); 
        res = preNum; 
        
        // Calculate the final result
        while (idx < s.length()) {
            // Get the operation
            idx = skipSpces(idx, s); 
            char operation = s.charAt(idx++); 
            
            // Get the next number
            idx = skipSpces(idx, s); 
            StringBuilder nextNumString = new StringBuilder(); 
            while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                nextNumString.append(s.charAt(idx++)); 
            }
            int nextNum = Integer.valueOf(nextNumString.toString()); 

            // Calculate the expression
            if (operation == '+') {
                res += nextNum; 
                preNum = nextNum; 
            } else if (operation == '-') {
                res -= nextNum; 
                preNum = -nextNum; 
            } else if (operation == '*') {
                res -= preNum; 
                res += preNum * nextNum; 
                preNum = preNum * nextNum; 
            } else {
                res -= preNum; 
                res += preNum / nextNum; 
                preNum = preNum / nextNum; 
            } 
        }
        
        // Return result
        return res; 
    }
    
    private int skipSpces(int curIdx, String s) {
        while (curIdx < s.length() && s.charAt(curIdx) == ' ') {
                curIdx++; 
        }
        return curIdx; 
    }
}