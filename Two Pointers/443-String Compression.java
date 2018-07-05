/**
443. String Compression

Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
Example 2:
Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
Note:
All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.

Solution: Two pointers. 
*/

// My version. 
class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1; 
        int cur = 1, pre = 0, count = 1; 
        char preChar = chars[0]; 
        for (; cur < chars.length; cur++) {
            if (chars[cur] == preChar) {
                count++; 
                if (cur == chars.length - 1) {
                    String num = String.valueOf(count); 
                    for (int i = 0; i < num.length(); i++) {
                        chars[++pre] = num.charAt(i); 
                    }
                }
            } else {
                if (count > 1) {
                    String num = String.valueOf(count); 
                    for (int i = 0; i < num.length(); i++) {
                        chars[++pre] = num.charAt(i); 
                    }
                    count = 1; 
                }
                chars[++pre] = chars[cur]; 
                preChar = chars[cur]; 
            }
        }
        return pre + 1; 
    }
}


class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0; 
        }
        int write = 0; 
        int read = 0; 
        int start = 0; 
        for (; read < chars.length; read++) {
            int cur = chars[read]; 
            if (read + 1 >= chars.length || chars[read + 1] != cur) {
                chars[write++] = chars[start]; 
                if (read != start) {
                    for (char c : String.valueOf(read - start + 1).toCharArray()) {
                        chars[write++] = c; 
                    }
                }
                start = read + 1; 
            }
        }
        return write; 
    }
}