/**
466. Count The Repetitions

Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".

On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.

You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.

Example:

Input:
s1="acb", n1=4
s2="ab", n2=2

Return:
2

Sol: DP. 
*/
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0; 
        }
        int[] repeatCnt = new int[s2.length() + 1]; 
        int[] idx = new int[s2.length() + 1]; 
        int nextIdx = 0; 
        int cnt = 0; 
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == s2.charAt(nextIdx)) {
                    if (nextIdx++ == s2.length() - 1) {
                        cnt++; 
                    }
                    nextIdx %= s2.length(); 
                }
            }
            repeatCnt[i] = cnt; 
            idx[i] = nextIdx; 
            for (int k = 0; k < i; k++) {
                if (idx[i] == idx[k]) {
                    int preK = repeatCnt[k]; 
                    int pattern = (repeatCnt[i] - repeatCnt[k]) * ((n1 - 1 - k) / (i - k)); 
                    int remaining = repeatCnt[k + (n1 - 1 - k) % (i - k)] - repeatCnt[k]; 
                    return (preK + pattern + remaining) / n2; 
                }
            }
        }
        return repeatCnt[n1 - 1] / n2; 
    }
}