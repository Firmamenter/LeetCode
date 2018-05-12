/**
17. Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

Solution: Backtracking. 
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>(); 
        if (digits == null || digits.length() == 0) {
            return res; 
        }
        Map<Character, String> mapping = new HashMap<>(); 
        mapping.put('0', ""); 
        mapping.put('1', ""); 
        mapping.put('2', "abc"); 
        mapping.put('3', "def"); 
        mapping.put('4', "ghi"); 
        mapping.put('5', "jkl"); 
        mapping.put('6', "mno"); 
        mapping.put('7', "pqrs"); 
        mapping.put('8', "tuv"); 
        mapping.put('9', "wxyz"); 
        helper(res, "", 0, mapping, digits); 
        return res; 
    }
    
    private void helper(List<String> res, String s, int pos, Map<Character, String> mapping, String digits) {
        if (pos == digits.length()) {
            res.add(s); 
            return; 
        }
        String map = mapping.get(digits.charAt(pos)); 
        for (int j = 0; j < map.length(); j++) {
            String temp = s + map.charAt(j) + ""; 
            helper(res, temp, pos + 1, mapping, digits); 
        }
    }
}