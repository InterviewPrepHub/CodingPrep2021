package Graph.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class GraphValidTree {

    int v;
    List<Integer> adjList[];

    GraphValidTree(int V) {
        this.v = V;
        adjList = new ArrayList[V];

        for (int i=0;i<V;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    private void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};

        GraphValidTree g = new GraphValidTree(n);

        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        System.out.println(g.validGraphTree());
    }

    private boolean validGraphTree() {

        boolean[] visited = new boolean[v];
        if(!helper(0, -1, adjList, visited)) {
            return false;
        }

        for(boolean b: visited){
            if(!b) {
                return false;
            }
        }

        return true;

    }

    public boolean helper(int curr, int parent, List<Integer> adjList[], boolean[] visited){
        if(visited[curr]) {
            return false;
        }

        visited[curr] = true;

        ListIterator<Integer> it = adjList[curr].listIterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i != parent && !helper(i, curr, adjList, visited)) {
                return false;
            }
        }

        return true;
    }

}
