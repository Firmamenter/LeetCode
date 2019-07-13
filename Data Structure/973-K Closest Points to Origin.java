/**
973. K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

Sol: Sort, Heap, Quick Selection. 
*/

// Quick Selection
class Solution {
    private class Point {
        int distance; 
        int[] location; 
        
        Point(int distance, int[] location) {
            this.distance = distance; 
            this.location = location; 
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        if (points[0].length != 2) {
            return new int[0][0]; 
        }
        List<Point> pointList = new ArrayList<>(); 
        for (int[] point : points) {
            int distance = (int)(Math.pow(point[0], 2) + Math.pow(point[1], 2)); 
            Point newPoint = new Point(distance, point); 
            pointList.add(newPoint); 
        }
        List<int[]> resultList = new ArrayList<>(); 
        int[][] result = new int[K][2]; 
        quickSelection(pointList, K, 0, points.length - 1, resultList); 
        for (int i = 0; i < K; i++) {
            result[i] = resultList.get(i); 
        }
        return result; 
    }
    
    private void quickSelection(List<Point> pointList, int K, int start, int end, List<int[]> resultList) {
        if (start > end) {
            return; 
        }
        int anchor = pointList.get(end).distance; 
        int idx = start; 
        int i = start; 
        for (; i < end; i++) {
            if (pointList.get(i).distance < anchor) {
                swap(pointList, i, idx); 
                idx++; 
            }
        }
        swap(pointList, i, idx); 
        if (idx - start + 1 == K) {
            addToResult(pointList, resultList, start, K); 
        } else if (idx - start + 1 < K) {
            addToResult(pointList, resultList, start, idx - start + 1); 
            quickSelection(pointList, K - (idx - start + 1), idx + 1, end, resultList); 
        } else {
            quickSelection(pointList, K, start, idx - 1, resultList); 
        }
    }
    
    private void swap(List<Point> pointList, int idx1, int idx2) {
        Point temp = pointList.get(idx1); 
        pointList.set(idx1, pointList.get(idx2)); 
        pointList.set(idx2, temp);  
    }
    
    private void addToResult(List<Point> pointList, List<int[]> resultList, int start, int num) {
        for (int i = 0; i < num; i++) {
            resultList.add(pointList.get(start + i).location); 
        }
    }
}

// Heap
class Solution {
    private class Point {
        int distance; 
        int[] location; 
        
        Point(int distance, int[] location) {
            this.distance = distance; 
            this.location = location; 
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        if (points[0].length != 2) {
            return new int[0][0]; 
        }
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(K, (a, b) -> b.distance - a.distance); 
        for (int[] point : points) {
            int distance = (int)(Math.pow(point[0], 2) + Math.pow(point[1], 2)); 
            Point newPoint = new Point(distance, point); 
            maxHeap.offer(newPoint); 
            if (maxHeap.size() > K) {
                maxHeap.poll(); 
            }
        }
        int[][] result = new int[K][2]; 
        for (int i = 0; i < K; i++) {
            result[i] = maxHeap.poll().location; 
        }
        return result; 
    }
}

// Sort
class Solution {
    private class Point {
        int distance; 
        int[] location; 
        
        Point(int distance, int[] location) {
            this.distance = distance; 
            this.location = location; 
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        if (points[0].length != 2) {
            return new int[0][0]; 
        }
        List<Point> pointList = new ArrayList<>(); 
        for (int[] point : points) {
            int distance = (int)(Math.pow(point[0], 2) + Math.pow(point[1], 2)); 
            Point newPoint = new Point(distance, point); 
            pointList.add(newPoint); 
        }
        Collections.sort(pointList, (a, b) -> a.distance - b.distance); 
        int[][] result = new int[K][2]; 
        for (int i = 0; i < K; i++) {
            result[i] = pointList.get(i).location; 
        }
        return result; 
    }
}