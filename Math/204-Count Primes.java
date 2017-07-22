/**
204. Count Primes

Description:

Count the number of prime numbers less than a non-negative number, n.

Solution: sieve of Eratosthenes. Math. O(NloglogN). 
*/

public class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0; 
        }
        boolean[] notPrime = new boolean[n]; 
        int count = 0; 
        for (int i = 2; i <= n; i++) {
            if (!notPrime[i - 1]) {
                count++; 
                for (int j = 2; j * i <= n; j++) {
                    notPrime[j * i - 1] = true; 
                }
            }
        }
        return notPrime[n - 1] ? count : count - 1; 
    }
}