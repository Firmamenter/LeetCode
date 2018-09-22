/**
338. Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

Solution: DP. 
0    0000    0
-------------
1    0001    1
-------------
2    0010    1
3    0011    2
-------------
4    0100    1
5    0101    2
6    0110    2
7    0111    3
-------------
8    1000    1
9    1001    2
10   1010    2
11   1011    3
12   1100    2
13   1101    3
14   1110    3
15   1111    4
*/

// Naive Solution. 
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1]; 
        for (int i = 0; i <= num; i++) {
            int temp = i; 
            while (temp != 0) {
                res[i] += (temp & 1); 
                temp >>= 1; 
            }
        }
        return res; 
    }
}

// DP Solution. 
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1]; 
        if (num == 0) {
            return res; 
        }
        res[1] = 1; 
        int i = 2; 
        int exp = 2; 
        while (i <= num) {
            for (; i < (int)Math.pow(2, exp) && i <= num; i++) {
                if (i < (int)Math.pow(2, exp - 1) + (int)Math.pow(2, exp - 2)) {
                    res[i] = res[i - (int)Math.pow(2, exp - 2)]; 
                } else {
                    res[i] = res[i - (int)Math.pow(2, exp - 2)] + 1; 
                }
            }
            exp++; 
        }
        return res; 
    }
}