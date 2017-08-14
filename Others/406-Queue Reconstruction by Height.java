/**
406. Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

Solution: Greedy. 
*/

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length < 2) {
            return new int[0][0]; 
        }
        
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); 
        List<int[]> list = new ArrayList<>(); 
        list.add(people[0]); 
        for (int i = 1; i < people.length; i++) {
            int size = list.size(); 
            for (int j = 0; j <= size; j++) {
                if (j == size) {
                    list.add(people[i]); 
                    break; 
                } 
                if (list.get(j)[1] == people[i][1]) {
                    list.add(j, people[i]); 
                    break; 
                }
                if (j == people[i][1]) {
                    list.add(j, people[i]); 
                    break; 
                }
            }
        }
        int[][] res = new int[list.size()][2]; 
        res = list.toArray(res); 
        return res; 
    }
}

// Simplified vesion. 
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length < 2) {
            return new int[0][0]; 
        }
        
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); 
        List<int[]> list = new ArrayList<>(); 
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]); 
        }
        int[][] res = new int[list.size()][2]; 
        res = list.toArray(res); 
        return res; 
    }
}