/**
937. Reorder Log Files

You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.

Sol: String + Sort. 
*/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> llogs = new ArrayList<>();
        List<String> dlogs = new ArrayList<>();
        for(String s: logs) {
            int i = s.indexOf(" ");
            char ch = s.charAt(i+1);
            if(ch >= '0' && ch <= '9' ) {
                dlogs.add(s);
            }
            else {
                llogs.add(s);
            }
        }

        Collections.sort(llogs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index1 = s1.indexOf(" ");
                String id1 = s1.substring(0, index1);
                String letter1 = s1.substring(index1+1);

                int index2 = s2.indexOf(" ");
                String id2 = s2.substring(0, index2);
                String letter2 = s2.substring(index2+1);
                int v1 = letter1.compareTo(letter2);
                if(v1 != 0) return v1;
                int v2 = id1.compareTo(id2);
                return v2;
            }
        });
        String[] result = new String[llogs.size() + dlogs.size()];
        int i = 0;
        for(String s: llogs) {
            result[i++] = s;
        }
        for(String s: dlogs) {
            result[i++] = s;
        }
        return result;   
    }
}