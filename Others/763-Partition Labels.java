/**
763. Partition Labels

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

Sol: Greedy
*/

// Initial trial
class Solution {
    private class Interval {
        int start; 
        int end; 
        
        Interval(int start, int end) {
            this.start = start; 
            this.end = end; 
        }
    }
    
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> firstIdx = new HashMap<>(); 
        Map<Character, Integer> lastIdx = new HashMap<>(); 
        for (int i = 0; i < S.length(); i++) {
            if (!firstIdx.containsKey(S.charAt(i))) {
                firstIdx.put(S.charAt(i), i); 
            }
            lastIdx.put(S.charAt(i), i); 
        }
        
        List<Interval> intervals = new ArrayList<>(); 
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'a'); 
            if (firstIdx.containsKey(c)) {
                Interval interval = new Interval(firstIdx.get(c), lastIdx.get(c)); 
                intervals.add(interval); 
            }
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start); 
        
        List<Integer> res = new ArrayList<>(); 
        Interval cur = intervals.get(0); 
        for (int i = 1; i <= intervals.size(); i++) {
            if (i == intervals.size()) {
                res.add(cur.end - cur.start + 1); 
                break; 
            }
            if (cur.end < intervals.get(i).start) {
                res.add(cur.end - cur.start + 1); 
                cur = intervals.get(i); 
            } else {
                cur.end = Math.max(intervals.get(i).end, cur.end); 
            }
        }
        
        return res; 
    }
}

// Modified version
class Solution {    
    public List<Integer> partitionLabels(String S) {
        int lastIndex[] = new int[128];
        for (int i = 0; i < S.length(); ++i)
          lastIndex[(int)S.charAt(i)] = i;
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); ++i) {
          end = Math.max(end, lastIndex[(int)S.charAt(i)]);
          if (i == end) {
            ans.add(end - start + 1);
            start = end + 1;
          }
        }
        return ans;
    }
}

// Last trial
class Solution {
    public List<Integer> partitionLabels(String S) {
        int start = 0; 
        int end = 0; 
        List<Integer> result = new ArrayList<>(); 
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, S.lastIndexOf(S.charAt(i))); 
            if (i == end) {
                result.add(end - start + 1); 
                if (i + 1 < S.length()) {
                    start = i + 1; 
                    end = S.lastIndexOf(S.charAt(i + 1)); 
                }
                continue; 
            }
        }
        return result; 
    }
}