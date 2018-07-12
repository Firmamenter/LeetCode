/**
394. Decode String

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

Sol: Stack. 
*/

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>(); 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i)); 
            } else {
                expand(stack); 
            }
        }
        StringBuilder res = new StringBuilder(""); 
        while (!stack.empty()) {
            res.append(stack.pop()); 
        }
        return res.reverse().toString(); 
    }
    
    private void expand(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder(""); 
        while (stack.peek() != '[') {
            sb.append(stack.pop()); 
        }
        stack.pop(); 
        sb.reverse(); 
        StringBuilder times = new StringBuilder(""); 
        while (!stack.empty() && Character.isDigit(stack.peek())) {
            times.append(stack.pop()); 
        }
        times.reverse(); 
        if (times.length() == 0) {
            times.append("1"); 
        }
        StringBuilder result = new StringBuilder("");  
        for (int i = 0; i < Integer.valueOf(times.toString()); i++) {
            result.append(sb); 
        }
        for (int i = 0; i < result.length(); i++) {
            stack.push(result.charAt(i)); 
        }
    }
}