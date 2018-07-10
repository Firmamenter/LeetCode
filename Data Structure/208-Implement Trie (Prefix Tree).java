/**
208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

Sol: Tire
*/

class Trie {
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
    public Trie() {
        root = new TireNode('0'); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TireNode res = helper(word); 
        return res != null && res.isWord; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return helper(prefix) != null; 
    }
    
    private TireNode helper(String word) {
        TireNode cur = root; 
        Map<Character, TireNode> curChildern = cur.childern; 
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); 
            if (!curChildern.containsKey(c)) {
                return null; 
            }
            cur = curChildern.get(c); 
            curChildern = cur.childern; 
        }
        return cur; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */