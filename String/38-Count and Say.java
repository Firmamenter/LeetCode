/**
38. Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Sol: Every kinds of digit chas two parts - count, say.
*/

public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null; 
        } else if (n == 1) {
            return "1"; 
        }
        int i; 
        int count; 
        char say; 
        String seq = "1";
        for (i = 0; i < n - 1; i++) {
            StringBuilder res = new StringBuilder(); 
            say =  seq.charAt(0); 
            count = 1; 
            for (int j = 1; j < seq.length(); j++) {
                if (seq.charAt(j) == say) {
                    count++; 
                } else {
                    res.append(count);
                    res.append(say); 
                    say = seq.charAt(j); 
                    count = 1; 
                }
            }
            res.append(count); 
            res.append(say); 
            seq = res.toString(); 
        }
        return seq; 
    }
}