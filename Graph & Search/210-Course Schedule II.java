/**
210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Sol: Topological sorting. 
*/
class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || (prerequisites.length > 0 && prerequisites[0].length != 2)) {
            return new int[0]; 
        }
        List<Integer> resultList = new ArrayList<>(); 
        Map<Integer, Set<Integer>> graph = new HashMap<>(); 
        int[] visitState = new int[numCourses]; 
        buildGraph(graph, visitState, prerequisites); 
        for (int i = 0; i < numCourses; i++) {
            if (visitState[i] == 0) {
                if (dfs(graph, visitState, i, resultList)) {
                    return new int[0]; 
                }
            }
        }
        Collections.reverse(resultList); 
        int[] result = new int[numCourses]; 
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i); 
        }
        return result; 
    }
    
    private void buildGraph(Map<Integer, Set<Integer>> graph, int[] visitState, int[][] prerequisites) {
        for (int[] edge : prerequisites) {
            graph.putIfAbsent(edge[1], new HashSet<Integer>()); 
            graph.get(edge[1]).add(edge[0]); 
        }
    }
    
    private boolean dfs(Map<Integer, Set<Integer>> graph, int[] visitState, int startPoint, List<Integer> resultList) {
        visitState[startPoint] = -1; 
        boolean hasCircle = false; 
        if (graph.containsKey(startPoint)) {
            for (int nextPoint : graph.get(startPoint)) {
                if (visitState[nextPoint] == -1) {
                    return true; 
                } else if (visitState[nextPoint] == 0) {
                    hasCircle = hasCircle || dfs(graph, visitState, nextPoint, resultList); 
                }
            }
        }
        visitState[startPoint] = 1; 
        resultList.add(startPoint); 
        return hasCircle; 
    }
}