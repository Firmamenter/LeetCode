/**
218. The Skyline Problem

A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

Sol: Sweep line + Heap. 
*/

class Solution {
    private class Tri {
        int idx; 
        int height; 
        boolean start; 
        Tri(int idx, int height, boolean start) {
            this.idx = idx; 
            this.height = height; 
            this.start = start; 
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0 || buildings[0].length < 3) {
            return new ArrayList<int[]>(); 
        }
        List<Tri> list = new ArrayList<>(); 
        for (int i = 0; i < buildings.length; i++) {
            list.add(new Tri(buildings[i][0], buildings[i][2], true)); 
            list.add(new Tri(buildings[i][1], buildings[i][2], false)); 
        }
        Collections.sort(list, (a, b) -> a.idx - b.idx); 
        list.add(new Tri(list.get(list.size() - 1).idx + 1, -1, true)); 
        TreeMap<Integer, Integer> skyline = new TreeMap<>();  
        List<int[]> res = new ArrayList<>(); 
        int[] prev = new int[]{list.get(0).idx, 0}; 
        for (int i = 0; i < list.size(); i++) {
            Tri cur = list.get(i); 
            if (cur.start) {
                skyline.put(cur.height, skyline.getOrDefault(cur.height, 0) + 1); 
            } else {
                if (skyline.get(cur.height) == 1) {
                    skyline.remove(cur.height); 
                } else {
                    skyline.put(cur.height, skyline.get(cur.height) - 1); 
                }
            }
            if (cur.idx == prev[0]) { // 关键点一：只要idx相同，不停更新当前最大值
                prev[1] = skyline.size() == 0 ? 0 : skyline.lastKey(); 
            } else { // 关键点二：idx一旦不同，检验是否加入res，如果height和之前相同则没必要加；无论如何prev都要更新
                if (res.size() == 0 || res.get(res.size() - 1)[1] != prev[1]) {
                    res.add(new int[]{prev[0], prev[1]}); 
                }
                prev[0] = cur.idx; 
                prev[1] = skyline.size() == 0 ? 0 : skyline.lastKey(); 
            }
        }
        
        return res; 
    }
}