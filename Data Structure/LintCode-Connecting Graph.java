/**
LintCoode: Connecting Graph

Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:

connect(a, b), add an edge to connect node a and node b`.
query(a, b), check if two nodes are connected

Sol: Union-find
*/

public class ConnectingGraph { 

    private int[] father = null;

    private int find(int x) {
        if (father[x] == x) {
            return x; 
        }
        father[x] = find(father[x]); 
        return father[x]; 
    }

    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n + 1]; 
        for (int i = 1; i <= n; i++) {
            father[i] = i; 
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int fatherA = find(a); 
        int fatherB = find(b); 
        if (fatherA != fatherB) {
            father[a] = fatherB; 
        }
    }
        
    public boolean query(int a, int b) {
        // Write your code here
        return find(a) == find(b); 
    }
}