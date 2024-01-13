package Graph.Level1;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.PriorityQueue;

/**
 *  Dijkstra algorithm is one of the prominent algorithms to find the shortest path from the source node
 *  to a destination node
 */
public class DijkstraAlgo {

    static int v;
    ArrayList<EdgeWithWt> adj[] = null;

    DijkstraAlgo(int V) {
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

    //find the min length of wire to connect to all nodes

    public static void main(String[] args) {
        int n = 7;
        DijkstraAlgo h = new DijkstraAlgo(n);

        h.addEdge(0,1,10);
        h.addEdge(0,3,40);
        h.addEdge(1,0,10);
        h.addEdge(1,2,10);
        h.addEdge(2,1,10);
        h.addEdge(2,3,10);
        h.addEdge(3,0,40);
        h.addEdge(3,4,2);
        h.addEdge(4,5,3);
        h.addEdge(4,6,8);
        h.addEdge(5,6,3);
        h.addEdge(5,4,3);
        h.addEdge(6,4,8);
        h.addEdge(6,5,3);

        boolean[] visited= new boolean[n];
        h.DA(0, visited,"");

    }

    private void addEdge(int src, int nbr, int wt) {
        adj[src].add(new EdgeWithWt(src,nbr,wt));
    }

    public void DA(int src, boolean[] visited, String psf) {

        PriorityQueue<Pair3> pq = new PriorityQueue<>();
        pq.add(new Pair3(src, 0, src+""));

        while (!pq.isEmpty()) {
            Pair3 rem = pq.remove();

            if (visited[rem.v] == true ) {
                continue;
            } else {
                visited[rem.v] = true;

                System.out.println(rem.v+" via "+rem.psf+" @ "+rem.wt);

                ListIterator<EdgeWithWt> it = adj[rem.v].listIterator();
                while (it.hasNext()) {
                    EdgeWithWt edge = it.next();
                    if (visited[edge.nbr] == false) {
                        pq.add(new Pair3(edge.nbr, edge.wt+ rem.wt, rem.psf+edge.nbr));
                    }
                }
            }

        }

    }
}

class Pair3 implements Comparable<Pair3> {
    int v;
    int wt;
    String psf;

    public Pair3(int v, int wt, String psf) {
        this.v = v;
        this.wt = wt;
        this.psf = psf;
    }

    @Override
    public int compareTo(Pair3 o) {
        return this.wt - o.wt;
    }
}
