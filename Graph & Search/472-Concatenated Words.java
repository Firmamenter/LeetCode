/**
472. Concatenated Words

Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.

Solution: DFS. Word may be empty.
*/

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>(); 
        if (words == null || words.length < 2) {
            return res; 
        }
        Set<String> set = new HashSet<>(); 
        for (String word : words) {
            set.add(word); 
        }
        for (String word : words) {
            if (helper(words, word, 0, res, set)) {
                res.add(word); 
            } 
        }
        return res; 
    }
    
    private boolean helper(String[] words, String word, int idx, List<String> res, Set<String> set) {
        if (word.length() == 0) {
            return false; 
        }
        if (idx == word.length()) {
            return true; 
        }
        boolean flag = false; 
        for (int i = word.length(); i >= idx + 1; i--) {
            String sub = word.substring(idx, i); 
            if (set.contains(sub) && !sub.equals(word)) {
                flag = flag || helper(words, word, i, res, set);    //Just need one helper() to be true 
            }
        }
        return flag; 
    }
}