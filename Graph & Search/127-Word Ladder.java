/**
127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Solution: Use BFS.
*/
// Space: O(n)   Time: O(k*n^2) (k is word length)
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>(); 
        queue.offer(beginWord); 
        boolean[] isUsed = new boolean[wordList.size()]; 
        int level = 1; 
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            level++; 
            for (int i = 0; i < size; i++) {
                String temp = queue.poll(); 
                for (int j = 0; j < wordList.size(); j++) {
                    if (!isUsed[j] && canTrans(temp, wordList.get(j))) {
                        if (wordList.get(j).equals(endWord)) {
                            return level; 
                        }
                        isUsed[j] = true; 
                        queue.offer(wordList.get(j)); 
                    }
                }
            }
        }
        return 0; 
    }
    
    private boolean canTrans(String a, String b) {
        int flag = 0; 
        for (int i = 0; i < a.length(); i++) {
            if (flag > 1) {
                return false; 
            }
            if (a.charAt(i) != b.charAt(i)) {
                flag++; 
            }
        }
        return flag == 1; 
    }
}

// Faster. Space: O(n)   Time: O(n*k) (k is word length)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(); 
        for (String word : wordList) {
            wordSet.add(word); 
        }
        wordSet.remove(beginWord); 
        Queue<String> queue = new LinkedList<>(); 
        queue.offer(beginWord); 
        int level = 1; 
        while (!queue.isEmpty()) {
            level++; 
            int len = queue.size(); 
            for (int i = 0; i < len; i++) {
                String cur = queue.poll(); 
                List<String> transWords = getTransWords(wordSet, cur); 
                for (String word : transWords) {
                    if (word.equals(endWord)) {
                        return level; 
                    }
                    queue.offer(word); 
                }
            }
        }
        return 0; 
    }
    
    private List<String> getTransWords(Set<String> wordSet, String cur) {
        List<String> res = new ArrayList<>(); 
        char[] charArr = cur.toCharArray(); 
        for (int i = 0; i < cur.length(); i++) {
            char oriChar = charArr[i]; 
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oriChar) {
                    continue; 
                }
                charArr[i] = c; 
                String str = new String(charArr); 
                if (wordSet.contains(str)) {
                    wordSet.remove(str); 
                    res.add(str); 
                }
            }
            charArr[i] = oriChar; 
        }
        return res; 
    }
}