/**
207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Sol: DFS with directed graph.
*/

class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || (prerequisites.length > 0 && prerequisites[0].length != 2)) {
            return false; 
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>(); 
        int[] visitState = new int[numCourses]; 
        buildGraph(graph, visitState, prerequisites); 
        boolean hasCircle = false; 
        for (int i = 0; i < numCourses; i++) {
            if (visitState[i] == 0) {
                hasCircle = hasCircle || searchCircle(graph, visitState, i); 
            }
        }
        return !hasCircle; 
    }
    
    private void buildGraph(Map<Integer, Set<Integer>> graph, int[] visitState, int[][] prerequisites) {
        for (int[] edge : prerequisites) {
            graph.putIfAbsent(edge[1], new HashSet<Integer>()); 
            graph.get(edge[1]).add(edge[0]); 
        }
    }
    
    private boolean searchCircle(Map<Integer, Set<Integer>> graph, int[] visitState, int startPoint) {
        visitState[startPoint] = -1; 
        boolean hasCircle = false; 
        if (graph.containsKey(startPoint)) {
            for (int nextPoint : graph.get(startPoint)) {
                if (visitState[nextPoint] == -1) {
                    return true; 
                } else if (visitState[nextPoint] == 0) {
                    hasCircle = hasCircle || searchCircle(graph, visitState, nextPoint); 
                }
            }
        }
        visitState[startPoint] = 1; 
        return hasCircle; 
    }
}

class Solution {
    private class Course {
        int id; 
        List<Integer> nextCourses; 
        
        Course(int id) {
            this.id = id; 
            nextCourses = new ArrayList<Integer>(); 
        }
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Course> courseList = new ArrayList<>(); 
        buildCourseTree(courseList, numCourses, prerequisites); 
        int[] isTaken = new int[numCourses]; 
        for (int i = 0; i < numCourses; i++) {
            if (checkAllCourses(courseList, courseList.get(i), isTaken)) return false;  
        }
        return true; 
    }
    
    private void buildCourseTree(List<Course> courseList, int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) courseList.add(new Course(i)); 
        for (int[] prerequisite : prerequisites) courseList.get(prerequisite[1]).nextCourses.add(prerequisite[0]); 
    }
    
    private boolean checkAllCourses(List<Course> courseList, Course course, int[] isTaken) {
        if (isTaken[course.id] == -1) return true; 
        if (isTaken[course.id] == 1) return false; 
        
        isTaken[course.id] = -1; 
        boolean circleIsFound = false; 
        for (Integer nextCourseId : course.nextCourses) {
            circleIsFound = circleIsFound || checkAllCourses(courseList, courseList.get(nextCourseId), isTaken); 
        }
        isTaken[course.id] = 1; 
        return circleIsFound; 
    }
}

class Solution {
    private class Course {
        int id; 
        List<Integer> nextCourses; 
        
        Course(int id) {
            this.id = id; 
            nextCourses = new ArrayList<Integer>(); 
        }
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Course> courseList = new ArrayList<>(); 
        buildCourseTree(courseList, numCourses, prerequisites); 
        boolean[] isTaken = new boolean[numCourses]; 
        boolean hasCircle = false; 
        for (int i = 0; i < numCourses; i++) {
            hasCircle = hasCircle || checkAllCourses(courseList, courseList.get(i), isTaken); 
        }
        return !hasCircle; 
    }
    
    private void buildCourseTree(List<Course> courseList, int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            courseList.add(new Course(i)); 
        }
        for (int[] prerequisite : prerequisites) {
            courseList.get(prerequisite[1]).nextCourses.add(prerequisite[0]);
        }
    }
    
    private boolean checkAllCourses(List<Course> courseList, Course course, boolean[] isTaken) {
        boolean circleIsFound = false; 
        isTaken[course.id] = true; 
        for (Integer nextCourseId : course.nextCourses) {
            if (isTaken[nextCourseId]) circleIsFound = true; 
            circleIsFound = circleIsFound || checkAllCourses(courseList, courseList.get(nextCourseId), isTaken); 
        }
        isTaken[course.id] = false; 
        return circleIsFound; 
    }
}