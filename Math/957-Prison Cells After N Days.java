/**
957. Prison Cells After N Days

There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

 

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
 

Note:

cells.length == 8
cells[i] is in {0, 1}
1 <= N <= 10^9

Sol: Math. 
*/

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> recoder = new HashMap<>(); 
        Map<Integer, String> getStringFromIndex = new HashMap<>(); 
        String initalRow = ""; 
        for (int cell : cells) {
            initalRow += cell + ""; 
        }
        String row = initalRow; 
        int[] result = new int[8]; 
        String resultString = ""; 
        recoder.put(row, 0); 
        getStringFromIndex.put(0, row); 
        for (int i = 1; i <= N; i++) {
            row = getNextRow(row); 
            if (recoder.containsKey(row)) {
                int firstIdx = recoder.get(row); 
                int endIdx = (N - firstIdx) % (i - firstIdx); 
                resultString = getStringFromIndex.get(firstIdx + endIdx); 
                break; 
            } else {
                recoder.put(row, i); 
                getStringFromIndex.put(i, row); 
            }
        }
        resultString = resultString.equals("") ? row : resultString; 
        for (int i = 0; i < 8; i++) {
            result[i] = resultString.charAt(i) - '0'; 
        }
        return result; 
    }
    
    private String getNextRow(String row) {
        StringBuilder nextRow = new StringBuilder(); 
        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 7) {
                nextRow.append("0"); 
            } else if (row.charAt(i - 1) == '1' && row.charAt(i + 1) == '1' || row.charAt(i - 1) == '0' && row.charAt(i + 1) == '0') {
                nextRow.append("1"); 
            } else {
                nextRow.append("0"); 
            }
        }
        return nextRow.toString(); 
    }
}