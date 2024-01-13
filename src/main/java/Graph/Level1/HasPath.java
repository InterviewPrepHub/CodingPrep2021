package Graph.Level1;

import java.util.ArrayList;
import java.util.ListIterator;

public class HasPath {

    int v;
    ArrayList<EdgeWithWt> adj[];

    public HasPath(int V) {
        v = V;
        adj = new ArrayList[V];
        for (int i=0;i<V;i++) {
            adj[i] = new ArrayList<EdgeWithWt>();
        }
    }

    void addEdge(int src, int nbr, int wt) {
        adj[src].add(new EdgeWithWt(src,nbr,wt));
    }

    public static void main(String[] args) {
        
        HasPath h = new HasPath(4);
        h.addEdge(0,1,2);
        h.addEdge(0,2,2);
        h.addEdge(1,0,2);
        h.addEdge(1,3,1);
        h.addEdge(2,0,2);
        h.addEdge(2,1,1);
        h.addEdge(2,3,2);
        h.addEdge(3,1,1);
        h.addEdge(3,2,2);

        boolean[] visited = new boolean[4];
        boolean res = h.hasPath(2, 3, visited);
        System.out.println(res);

    }

    private boolean hasPath(int src, int dest, boolean[] visited) {
        System.out.println(src);

        if (src == dest) {
            return true;
        }

        visited[src] = true;
        ListIterator<EdgeWithWt> i = adj[src].listIterator();
        while (i.hasNext()) {
            EdgeWithWt edge = i.next();
            if (visited[edge.nbr] == false) {
                boolean hasNbrPath = hasPath(edge.nbr, dest, visited);
                if (hasNbrPath == true) {
                    return true;
                }
            }
        }
        return false;
    }

}























