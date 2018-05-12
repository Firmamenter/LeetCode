/**
126. Word Ladder II

Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

Solution: (1)首先用BFS找到最短距离, 同时用Map记录下图 (2)用DFS探索所有路径 (3)Set的addAll和removeAll
*/

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> setBFS = new HashSet<>(wordList); 
        setBFS.remove(beginWord); 
        Map<String, Set<String>> map = new HashMap<>(); 
        int level = bfs(beginWord, endWord, setBFS, map); 
        List<List<String>> result = new ArrayList<>(); 
        List<String> list = new ArrayList<>(); 
        list.add(beginWord); 
        dfs(result, list, beginWord, endWord, 0, level, map); 
        return result; 
    }

    private int bfs(String beginWord, String endWord, Set<String> set, Map<String, Set<String>> map) {
        Queue<String> queue = new LinkedList<>(); 
        queue.offer(beginWord); 
        boolean flag = false; 
        int level = 0; 
        while (!queue.isEmpty()) {
            level++; 
            int len = queue.size(); 
            Set<String> visited = new HashSet<>(); 
            for (int i = 0; i < len; i++) {
                String cur = queue.poll(); 
                List<String> list = canTrans(cur, set, map); 
                for (String str : list) {
                    if (str.equals(endWord)) flag = true; 
                    if (visited.contains(str)) continue; 
                    queue.offer(str); 
                }
                visited.addAll(list); 
            }
            set.removeAll(visited); 
            if (flag) return level; 
        }
        return level; 
    }

    private List<String> canTrans(String cur, Set<String> set, Map<String, Set<String>> map) {
        map.putIfAbsent(cur, new HashSet<String>()); 
        List<String> res = new ArrayList<>(); 
        char[] charArr = cur.toCharArray(); 
        for (int i = 0; i < charArr.length; i++) {
            char orig = charArr[i]; 
            for (char c = 'a'; c <= 'z'; c++) {
                if (orig == c) continue; 
                charArr[i] = c; 
                String newStr = new String(charArr); 
                if (set.contains(newStr)) {
                    map.get(cur).add(newStr); 
                    res.add(newStr); 
                }
            }
            charArr[i] = orig; 
        }
        return res; 
    }

    private void dfs(List<List<String>> result, List<String> list, String beginWord, String endWord, 
                     int count, int level, Map<String, Set<String>> map) {
        if (count > level) return; 
        if (count == level && !beginWord.equals(endWord)) return; 
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList(list)); 
            return; 
        }
        for (String str : map.get(beginWord)) {
            list.add(str); 
            dfs(result, list, str, endWord, count + 1, level, map); 
            list.remove(list.size() - 1); 
        }
    }
}