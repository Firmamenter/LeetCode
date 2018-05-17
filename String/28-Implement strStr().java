/**
28. Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Solution: strName.indexOf()
*/

// Use built-in function. 
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); 
    }
}

// Use brute-force O(mn)
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1; 
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j <= needle.length(); j++) {
                if (j == needle.length()) return i; 
                if (needle.charAt(j) != haystack.charAt(i + j)) break; 
            }
        }
        return -1; 
    }
}

// Rabin Karp算法 O(m + n)
// Java Mod 运算：不管除数被除数的符号，先全部当成正数处理，得到结果后，将结果符号变成被除数的符号
// 10 % 3 = 1; 10 % -3 = 1; -10 % 3 = -1; -10 % -3 = -1
// Mod运算规则
// (a + b) % p = (a % p + b % p) % p 
// (a - b) % p = (a % p - b % p) % p 
// (a * b) % p = (a % p * b % p) % p 
// a ^ b % p = ((a % p)^b) % p 
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1; 
        }
        
        int len = needle.length();
        if (len == 0) {
            return 0; 
        }
        
        int prime = 31; 
        int hashSize = 4096; 
        
        int needleCode = 0; 
        for (int i = 0; i < len; i++) {
            needleCode = (needleCode * prime + needle.charAt(i)) % hashSize; // 一个Mod等于对所有的数都取了模
        }
        
        int pow = 1; 
        for (int i = 0; i < len - 1; i++) {
            pow = (pow * prime) % hashSize; 
        }
         
        int hashCode = 0; 
        for (int i = 0; i < haystack.length(); i++) {
            if (i < len) {
                hashCode = (hashCode * prime + haystack.charAt(i)) % hashSize; 
            } else {
                hashCode = hashCode - (haystack.charAt(i - len) * pow) % hashSize; 
                if (hashCode < 0) {
                    hashCode += hashSize; 
                }
                hashCode = (hashCode * prime + haystack.charAt(i)) % hashSize; 
            }
            if (hashCode == needleCode && needle.equals(haystack.substring(Math.max(i - len + 1, 0), i + 1))) {
                    return i - len + 1; 
            }
        }
        return -1; 
    }
}