package Graph.Level1;

import java.util.ArrayList;
import java.util.ListIterator;

public class PrintAllPaths {

    static int v;
    ArrayList<EdgeWithWt> adj[] = null;

    PrintAllPaths(int V) {
        v = V;
        adj = new ArrayList[V];
        for (int i=0;i<V;i++) {
            adj[i] = new ArrayList<>();
        }
    }

//        40     2
//    0------3--------4
//    |      |       |  \
//  10|    10|     3 |   \ 8
//    1------2       5----6
//       10            3
    public static void main(String[] args) {
        PrintAllPaths h = new PrintAllPaths(4);

        h.addEdge(0,1,2);
        h.addEdge(0,2,2);
        h.addEdge(1,0,2);
        h.addEdge(1,3,1);
        h.addEdge(2,0,2);
        h.addEdge(2,1,1);
        h.addEdge(2,3,2);
        h.addEdge(3,1,1);
        h.addEdge(3,2,2);

        boolean[] visited = new boolean[v];

        h.printAllPaths(0,3,visited,0+"");
    }

    private void addEdge(int src, int nbr, int wt) {
        adj[src].add(new EdgeWithWt(src,nbr,wt));
    }

    private void printAllPaths(int src, int dest, boolean[] visited, String psf) {

        if (src == dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;
        ListIterator<EdgeWithWt> list = adj[src].listIterator();
        while (list.hasNext()) {
            EdgeWithWt edge = list.next();
            if (visited[edge.nbr] == false) {
                printAllPaths(edge.nbr, dest, visited, psf+edge.nbr);
            }
        }
        visited[src] = false;

    }
}
