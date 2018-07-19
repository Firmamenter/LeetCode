/**
LintCode: Copy Books

Description
Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?
Have you met this question in a real interview?  Yes
Example
Given array A = [3,2,4], k = 2.

Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )
Challenge
时间复杂度 O(nk)

Sol: 二分搜索答案，先猜一个答案，然后检验符不符合要求，根据检验结果二分.
*/

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0 || k <= 0) {
            return 0; 
        }
        int start = 0; 
        int end = 0; 
        for (int page : pages) {
            start = Math.max(start, page); 
            end += page; 
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; 
            if (copiers(pages, mid) <= k) {
                end = mid; 
            } else {
                start = mid; 
            }
        }
        if (copiers(pages, start) <= k) {
            return start; 
        } else {
            return end; 
        }
    }
    
    private int copiers(int[] pages, int num) {
        int res = 0; 
        int count = 0; 
        for (int i = 0; i < pages.length; ) {
            if (count + pages[i] > num) {
                count = 0; 
                res++; 
            } else {
                count += pages[i]; 
                if (i == pages.length - 1) {
                    res++; 
                }
                i++; 
            }
        }
        return res; 
    }
}