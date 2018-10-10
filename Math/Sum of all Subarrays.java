/**
Sum of all Subarrays

Given an integer array ‘arr[]’ of size n, find sum of all sub-arrays of given array.

Examples :

Input   : arr[] = {1, 2, 3}
Output  : 20
Explanation : {1} + {2} + {3} + {2 + 3} + 
              {1 + 2} + {1 + 2 + 3} = 20

Input  : arr[] = {1, 2, 3, 4}
Output : 50

Sol: Math
*/

/*
arr[] = [1, 2, 3], n = 3
All subarrays :  [1], [1, 2], [1, 2, 3], 
                 [2], [2, 3], [3]
here first element 'arr[0]' appears 3 times    
     second element 'arr[1]' appears 4 times  
     third element 'arr[2]' appears 3 times

Every element arr[i] appears in two types of subsets:
i)  In sybarrays beginning with arr[i]. There are 
    (n-i) such subsets. For example [2] appears
    in [2] and [2, 3].
ii) In (n-i)*i subarrays where this element is not
    first element. For example [2] appears in 
    [1, 2] and [1, 2, 3].

Total of above (i) and (ii) = (n-i) + (n-i)*i 
                            = (n-i)(i+1)
                                  
For arr[] = {1, 2, 3}, sum of subarrays is:
  arr[0] * ( 0 + 1 ) * ( 3 - 0 ) + 
  arr[1] * ( 1 + 1 ) * ( 3 - 1 ) +
  arr[2] * ( 2 + 1 ) * ( 3 - 2 ) 

= 1*3 + 2*4 + 3*3 
= 20
*/

public int subarraySum(int[] arr) {
    int len = arr.length; 
    int result = 0; 
    for (int i = 0; i < len; i++) {
        result += (arr[i] * (i + 1) * (len - i)); 
    }
    return result; 
}

