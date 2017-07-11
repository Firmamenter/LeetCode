/**
LintCode: Topological Sorting

Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

 Notice

You can assume that there is at least one topological order in the graph.

Clarification
Learn more about representation of graphs

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...

Solution: DFS.
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph == null || graph.size() == 0 || graph.size() == 1) {
            return graph; 
        }
        ArrayList<DirectedGraphNode> res = new ArrayList<>(); 
        Set<DirectedGraphNode> set = new HashSet<>(); 
        for (DirectedGraphNode node : graph) {
            if (!set.contains(node)) {
                helper(node, res, set); 
            }
        }
        Collections.reverse(res); 
        return res; 
    }
    
    private void helper(DirectedGraphNode node, ArrayList<DirectedGraphNode> res, Set<DirectedGraphNode> set) {
        set.add(node); 
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (!set.contains(neighbor)) {
                helper(neighbor, res, set); 
            }
        }
        res.add(node); 
    }
}