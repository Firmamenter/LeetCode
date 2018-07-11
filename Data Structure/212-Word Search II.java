/**
212. Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.

Sol: Tire + DFS. 
*/

class Solution {
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
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>(); 
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res; 
        }
        root = new TireNode('0'); 
        for (int i = 0; i < words.length; i++) {
            insert(words[i]); 
        }
        Set<String> set = new HashSet<>(); 
        StringBuilder sb = new StringBuilder(""); 
        boolean[][] isVisited = new boolean[board.length][board[0].length]; 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.childern.containsKey(board[i][j])) {
                    sb.append(board[i][j]); 
                    isVisited[i][j] = true; 
                    dfs(root.childern.get(board[i][j]), set, sb, board, i, j, isVisited); 
                    isVisited[i][j] = false; 
                    sb.deleteCharAt(0); 
                }
            }
        }
        res = new ArrayList<String>(set); 
        return res; 
    }
    
    private void insert(String word) {
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
    
    private void dfs(TireNode cur, Set<String> set, StringBuilder str, 
                     char[][] board, int row, int col, boolean[][] isVisited) { 
        if (cur.isWord) {
            set.add(str.toString()); 
        }
        int[] dr = {0, 0, 1, -1}; 
        int[] dc = {1, -1, 0, 0}; 
        Map<Character, TireNode> curChildern = cur.childern; 
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i]; 
            int newCol = col + dc[i]; 
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length 
                || isVisited[newRow][newCol] || !curChildern.containsKey(board[newRow][newCol])) {
                continue; 
            }
            str.append(board[newRow][newCol]); 
            isVisited[row][col] = true; 
            dfs(curChildern.get(board[newRow][newCol]), set, str, board, newRow, newCol, isVisited); 
            isVisited[row][col] = false; 
            str.deleteCharAt(str.length() - 1); 
        }
    }
}