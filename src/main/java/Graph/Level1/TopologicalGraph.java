package Graph.Level1;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

public class TopologicalGraph {

    int v;
    ArrayList<EdgeWOWt1> adjList[] = null;

    TopologicalGraph(int V) {
        v = V;
        adjList = new ArrayList[V];

        for (int i=0;i<v;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        TopologicalGraph s = new TopologicalGraph(n);
//        s.addEdge(0,1);
//        s.addEdge(0,3);
//        s.addEdge(1,2);
//        s.addEdge(2,3);
//        s.addEdge(4,3);
//        s.addEdge(4,5);
//        s.addEdge(4,6);
//        s.addEdge(5,6);
        s.addEdge(1,0);
        s.addEdge(2,0);
        s.addEdge(3,1);
        s.addEdge(3,2);
//        s.addEdge(4,3);



        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<n;i++) {
            if (visited[i] == false) {
                s.topological(i, visited, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }

    }

    //in topological sot u must appear before v
    public void addEdge(int src, int dest) {
        adjList[src].add(new EdgeWOWt1(src, dest));
    }

    public void topological(int src, boolean[] visited, Stack<Integer> st) {

        visited[src] = true;
        ListIterator<EdgeWOWt1> it = adjList[src].listIterator();
        while (it.hasNext()) {
            EdgeWOWt1 edge = it.next();
            if (visited[edge.nbr] == false) {
                topological(edge.nbr, visited, st);
            }
        }
        st.push(src);
    }
}

class EdgeWOWt1 {

    int src;
    int nbr;

    public EdgeWOWt1(int src, int nbr) {
        this.src = src;
        this.nbr = nbr;
    }
}


























