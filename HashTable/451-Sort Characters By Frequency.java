/**
451. Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

Solution: HashMap + sorting. 
*/

// Time O(n) Space O(n)
public class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s; 
        }
        
        Map<Character, Integer> count = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1); 
            } else {
                count.put(s.charAt(i), 1); 
            }
        }
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(count.entrySet()); 
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue()); 
        StringBuilder res = new StringBuilder(); 
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                res.append(list.get(i).getKey()); 
            }
        }
        return res.toString(); 
    }
}