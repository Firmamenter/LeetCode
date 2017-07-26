/**
383. Ransom Note

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

Solution: Map. 
*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false; 
        }
        char[] ransomNoteChars = ransomNote.toCharArray(); 
        char[] magazineChars = magazine.toCharArray(); 
        Map<Character, Integer> map = new HashMap<>(); 
        for (char letter : magazineChars) {
            if (map.containsKey(letter)) {
                map.put(letter, map.get(letter) + 1); 
            } else {
                map.put(letter, 1); 
            }
        }
        for (char letter : ransomNoteChars) {
            if (!map.containsKey(letter)) {
                return false; 
            } else if (map.get(letter) == 0) {
                return false; 
            } else {
                map.put(letter, map.get(letter) - 1); 
            }
        }
        return true; 
    }
}