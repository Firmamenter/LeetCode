/**
9.Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.

Solution: Use double pointers start and end.
*/

{
    public boolean isPalindrome(int x) {
        // negative integer is not a palindrome
        if (x < 0) {
            return false; 
        }
        
        // zero is a palindrome
        if (x == 0) {
            return true; 
        }
        
        // determine whether a positive integer is a palindrome
        // get the length of the integer first
        int len = 0; 
        int temp = x; 
        while (temp > 0) {
            len++; 
            temp = temp / 10; 
        }
        // determination
        int forward = 0; 
        int backward = 0; 
        temp = x; 
        for (int i = 0; i < len / 2 ; i++) {
            forward = temp / (int)Math.pow(10, len - 1 - i*2); 
            backward = temp % 10 ;
            if (forward != backward) {
                return false; 
            }
            temp -= forward * (int)Math.pow(10, len - 1 - i*2); 
            temp /= 10;
        }
        
        // a single digit positive integer is a palindrome, return true
        return true;
    }
}