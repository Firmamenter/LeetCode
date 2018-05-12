/**
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

Solution: DFS. 
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); 
        if (n <= 0) {
            return res; 
        }
        helper(res, "(", -1, n); 
        return res; 
    }
    
    private void helper(List<String> res, String solution, int potential, int n) {
        if (solution.length() == 2 * n) {
            if (potential == 0) {
                res.add(solution); 
            }
            return; 
        }
        if (potential < 0) {
            helper(res, solution + ")", potential + 1, n); 
        }
        helper(res, solution + "(", potential - 1, n); 
    }
}