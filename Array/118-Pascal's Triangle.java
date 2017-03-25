/**
118. Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

Solution: Find pattern.
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> level0 = new ArrayList<Integer>();

        if (numRows <= 0) {
            return result;
        }

        level0.add(1);
        result.add(level0);

        int level = 1;
        while (level < numRows) {
            List<Integer> temp = new ArrayList<Integer>();
            int i = 0;
            for (; i < level + 1; i++) {
                if (i == 0) {
                    temp.add(result.get(level - 1).get(0));
                } else if (i == level ) {
                    temp.add(result.get(level - 1).get(level - 1));
                } else {
                    temp.add(result.get(level - 1).get(i - 1) + result.get(level - 1).get(i));
                }
            }
            result.add(temp);
            level++;
        }
        return result;
    }
}