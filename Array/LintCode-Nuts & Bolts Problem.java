/**
LintCode: Nuts & Bolts Problem

Description
Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and bolts. Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

We will give you a compare function to compare nut with bolt.
Have you met this question in a real interview?  Yes
Problem Correction
Example
Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

Your code should find the matching bolts and nuts.

one of the possible return:

nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].

we will tell you the match compare function. If we give you another compare function.

the possible return is the following:

nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].

So you must use the compare function that we give to do the sorting.

The order of the nuts or bolts does not matter. You just need to find the matching bolt for each nut.

Sol: Divide and Conquer. Partition. 
*/

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || bolts == null || nuts.length <= 1 || 
        bolts.length <= 1 || nuts.length != bolts.length) {
            return; 
        }
        helper(nuts, 0, nuts.length - 1, bolts, 0, bolts.length - 1, compare); 
    }
    
    private void helper(String[] nuts, int nStart, int nEnd, String[] bolts, int bStart, int bEnd,  NBComparator compare) {
        if (nStart >= nEnd || bStart >= bEnd) {
            return; 
        }
        String pivot = nuts[nStart]; 
        int bIdx = bStart - 1; 
        for (int i = bStart; i <= bEnd; ) {
            int comp = compare.cmp(pivot, bolts[i]); 
            if (comp == 1) {
                swap(bolts, i++, ++bIdx); 
            } else if (comp == 0) {
                if (i == bEnd) {
                    break; 
                }
                swap(bolts, i, bEnd); 
            } else {
                i++; 
            }
        }
        swap(bolts, ++bIdx, bEnd); 
        swap(nuts, nStart, nEnd); 
        pivot = bolts[bIdx]; 
        int nIdx = nStart -1; 
        for (int i = nStart; i < nEnd;) {
            int comp = compare.cmp(nuts[i], pivot); 
            if (comp == -1) {
                swap(nuts, i++, ++nIdx); 
            } else if (comp == 1) {
                i++; 
            }
        }
        swap(nuts, ++nIdx, nEnd); 
        helper(nuts, nStart, nIdx - 1, bolts, bStart, bIdx - 1, compare); 
        helper(nuts, nIdx + 1, nEnd, bolts, bIdx + 1, bEnd, compare); 
    }
    
    private void swap(String[] arr, int left, int right) {
        String temp = arr[left]; 
        arr[left] = arr[right]; 
        arr[right] = temp; 
    }
};