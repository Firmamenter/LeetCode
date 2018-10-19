/**
LintCode: Flatten List

Description
Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.
If the element in the given list is a list, it can contain list too.
Have you met this question in a real interview?  Yes
Problem Correction
Example
Given [1,2,[1,2]], return [1,2,1,2].

Given [4,[3,[2,[1]]]], return [4,3,2,1].
Challenge
Do it in non-recursive.

Sol: Stack
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> res = new ArrayList<>(); 
        if (nestedList == null || nestedList.size() == 0) {
            return res; 
        }
        Stack<NestedInteger> stack = new Stack<>(); 
        for (NestedInteger i : nestedList) {
            stack.push(i); 
        }
        while (!stack.empty()) {
            NestedInteger cur = stack.pop(); 
            if (cur.isInteger()) {
                res.add(cur.getInteger()); 
            } else {
                List<NestedInteger> list = cur.getList(); 
                for (NestedInteger i : list) {
                    stack.push(i); 
                }
            }
        }
        Collections.reverse(res); 
        return res; 
    }
}