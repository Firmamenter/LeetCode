/**
211. Add and Search Word - Data structure design

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

Sol: Tire
*/

class WordDictionary {
    private class TireNode {
        char label; 
        boolean isWord; 
        Map<Character, TireNode> childern; 
        TireNode(char label) {
            this.label = label; 
            childern = new HashMap<Character, TireNode>(); 
        }
    }
    
    private TireNode root; 

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TireNode('0'); 
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TireNode cur = root; 
        Map<Character, TireNode> curChildern = cur.childern; 
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); 
            if (!curChildern.containsKey(c)) {
                curChildern.put(c, new TireNode(c)); 
            }
            cur = curChildern.get(c); 
            curChildern = cur.childern; 
        }
        cur.isWord = true; 
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0, root); 
    }
    
    private boolean helper(String word, int idx, TireNode cur) {
        if (idx == word.length()) {
            return cur != null && cur.isWord; 
        }
        char c = word.charAt(idx); 
        boolean wordIsFound = false; 
        Map<Character, TireNode> curChildern = cur.childern; 
        if (c == '.') {
            for (char key : curChildern.keySet()) {
                cur = curChildern.get(key); 
                wordIsFound = wordIsFound || helper(word, idx + 1, cur); 
            }
        } else {
            if (!curChildern.containsKey(c)) {
                return false; 
            } else {
                cur = curChildern.get(c); 
                wordIsFound = helper(word, idx + 1, cur); 
            }
        }
        return wordIsFound; 
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */