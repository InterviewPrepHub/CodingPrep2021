package Graph.Level1;

import java.util.*;

public class IsGraphCyclic {

    int v;
    ArrayList<EdgeWOWt> adj[];

    public IsGraphCyclic(int V) {
        v = V;
        adj = new ArrayList[V];
        for (int i=0;i<V;i++) {
            adj[i] = new ArrayList<EdgeWOWt>();
        }
    }

    private void addEdge(int src, int dest) {
        adj[src].add(new EdgeWOWt(src, dest));
    }

    public static void main(String[] args) {
        int n = 5;
        IsGraphCyclic g1 = new IsGraphCyclic(n);

//                0
//               / \
//              1---2

//        g1.addEdge(1, 0);
//        g1.addEdge(0, 2);
//        g1.addEdge(2, 1);
//        g1.addEdge(0, 3);
//        g1.addEdge(3, 4);

//        g1.addEdge(0, 1);
//        g1.addEdge(1, 2);

        g1.addEdge(0,1);
        g1.addEdge(0,2);

        g1.addEdge(1,2);
        g1.addEdge(2, 0);


//        g1.addEdge(1,0);
//        g1.addEdge(1,2);
//        g1.addEdge(2,0);
//        g1.addEdge(2,1);

//        g1.addEdge(0,1);
//        g1.addEdge(0,2);
//        g1.addEdge(1,3);
//        g1.addEdge(1,4);
//        g1.addEdge(3,4);

        /*boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++) {
            if(visited[i] == false) {
                boolean cycle =  g1.findCycle(i, "", visited);
                if (cycle) {
                    System.out.println("cycle");
                    return;
                }
            }
        }*/

        if (g1.isCyclic(n))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

    }

    private boolean isCyclic(int V) {

        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (detectCycle(u, visited, -1)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean detectCycle(int src, boolean[] visited, int parent) {

        visited[src] = true;

        ListIterator<EdgeWOWt> it = adj[src].listIterator();

        while(it.hasNext()) {
            EdgeWOWt edge = it.next();

            if(!visited[edge.nbr]) {
                if(detectCycle(edge.nbr, visited, edge.src)) {
                    return true;
                }
            } else if (src != parent) {
                return true;
            }
        }
        return false;

    }

    private boolean findCycle(int src, String psf, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, src+""));

        while (!q.isEmpty()) {

            Pair rem = q.remove();
            if (visited[rem.v] == true) {
                return true;
            }
            visited[rem.v] = true;
            ListIterator<EdgeWOWt> it = adj[src].listIterator();
            while (it.hasNext()) {
                EdgeWOWt edge = it.next();
                if (visited[edge.nbr] == false) {
                    q.add(new Pair(edge.nbr, psf+edge.nbr));
                }
            }
        }
        return false;
    }

}

class Pair {
    int v;
    String psf;

    Pair(int v, String psf) {
        this.v = v;
        this.psf = psf;
    }
}
