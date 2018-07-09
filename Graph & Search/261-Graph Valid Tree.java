/**
261. Graph Valid Tree

Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.

Sol: BFS, DFS, Union-Find
*/
// BFS
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0 && n != 1) {
            return false; 
        }
        
        if (n == 1 && edges.length == 0) {
            return true; 
        }
        
        boolean[] isVisited = new boolean[n]; 
        Map<Integer, Set<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < edges.length; i++) {
            int r = edges[i][0]; 
            int c = edges[i][1]; 
            if (!map.containsKey(r)) {
                map.put(r, new HashSet<Integer>()); 
            }
            map.get(r).add(c); 
            if (!map.containsKey(c)) {
                map.put(c, new HashSet<Integer>()); 
            }
            map.get(c).add(r); 
        }
        
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(edges[0][0]); 
        isVisited[edges[0][0]] = true; 
        while (!queue.isEmpty()) {
            int cur = queue.poll(); 
            for (int num : map.get(cur)) {
                map.get(num).remove(cur); 
                if (isVisited[num]) {
                    return false; 
                }
                queue.offer(num); 
                isVisited[num] = true; 
            }
        }
        
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                return false; 
            }
        }
        
        return true; 
    }
}

// Union-Find
class Solution {
    private int[] father; 
    boolean hasCircle; 
    private int count; 
    
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0 && n != 1 || edges.length >= n) {
            return false; 
        }
        
        if (n == 1 && edges.length == 0) {
            return true; 
        }
        
        count = n; 
        father = new int[n]; 
        for (int i = 0; i < n; i++) {
            father[i] = i; 
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (hasCircle) {
                return false; 
            }
            union(edges[i][0], edges[i][1]); 
        }
        
        return count == 1; 
    }
    
    private int find(int node) {
        if (father[node] == node) {
            return node; 
        }
        
        father[node] = find(father[node]); 
        return father[node]; 
    }
    
    private void union(int node1, int node2) {
        int father1 = find(node1); 
        int father2 = find(node2); 
        if (father1 != father2) {
            father[father1] = father2; 
            count--; 
        } else {
            hasCircle = true; 
        }
    }
}