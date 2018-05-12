/**
386. Lexicographical Numbers

Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

Solution: Math. Naive solution would be using string and sorting. 
*/

// Time: O(n)   Space: O(1)
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(); 
        if (n <= 0) {
            return list; 
        }
        int cur = 1; 
        for (int i = 1; i <= n; i++) {
            list.add(cur); 
            if (cur * 10 <= n) {
                cur *= 10; 
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur += 1; 
            } else {
                cur /= 10; 
                while (cur % 10 == 9) {
                    cur /= 10; 
                }
                cur++; 
            }
        }
        return list; 
    }
}