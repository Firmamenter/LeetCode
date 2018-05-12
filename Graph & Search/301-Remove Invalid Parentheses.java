/**
301. Remove Invalid Parentheses

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

Solution: DFS. "" is also valid. 
*/
// DFS. 加的思路
class Solution {
    private int max = Integer.MIN_VALUE; 
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>(); 
        if (s == null) {
            return res; 
        }
        Set<String> set = new HashSet<>(); 
        helper(res, s, "", 0, set, 0); 
        res = new ArrayList<String>(set); 
        return res; 
    }
    
    private void helper(List<String> res, String s, String cur, int idx, Set<String> set, int potential) {
        if (idx == s.length()) {
            if (potential == 0) {
                if (cur.length() > max) {
                    max = cur.length(); 
                    set.clear(); 
                }
                if (cur.length() == max) {
                    set.add(cur); 
                }
            }
            return; 
        }
        if (s.charAt(idx) == '(') {
            helper(res, s, cur + "(", idx + 1, set, potential + 1); 
            helper(res, s, cur, idx + 1, set, potential); 
        } else if (s.charAt(idx) == ')') {
            if (potential > 0) {
                helper(res, s, cur + ")", idx + 1, set, potential - 1); 
            }
            helper(res, s, cur, idx + 1, set, potential); 
        } else {
            helper(res, s, cur + s.charAt(idx) + "", idx + 1, set, potential); 
        }
    }
}

//BFS. 减的思路
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>(); 
        if (s == null) return res; 
        Set<String> isChecked = new HashSet<>(); 
        isChecked.add(s); 
        Queue<String> queue = new LinkedList<>(); 
        queue.offer(s); 
        boolean flag = false; 
        while (!queue.isEmpty()) {
            int len = queue.size(); 
            for (int i = 0; i < len; i++) {
                String cur = queue.poll(); 
                if (isValid(cur)) {
                    flag = true; 
                    res.add(cur); 
                }
                if (flag) continue; 
                for (int idx = 0; idx < cur.length(); idx++) {
                    String left = cur.substring(0, idx); 
                    String right = cur.substring(idx + 1); 
                    String total = left + right; 
                    if (isChecked.add(total)) queue.offer(total); 
                }
            }
            if (flag) break; 
        }
        return res; 
    }
    
    private boolean isValid(String cur) {
        int count = 0; 
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == '(') count++; 
            else if (cur.charAt(i) == ')') {
                if (count == 0) return false; 
                else count--; 
            }
        }
        return count == 0; 
    }
}