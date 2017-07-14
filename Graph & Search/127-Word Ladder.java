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