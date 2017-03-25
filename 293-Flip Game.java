/*
293. Flip Game
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
*/

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>(); 
        if (s.length() == 0) {
            return result; 
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder tempStr = new StringBuilder(s); 
                tempStr.setCharAt(i, '-');
                tempStr.setCharAt(i + 1, '-');
                result.add(tempStr.toString()); 
            }
        }
        return result; 
    }
}

public List<String> generatePossibleNextMoves(String s) {

    List<String> list = new ArrayList<String>();

    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
            list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
        }
    }

    return list;

}