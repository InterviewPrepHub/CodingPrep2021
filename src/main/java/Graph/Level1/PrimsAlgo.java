package Graph.Level1;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class PrimsAlgo {

    int v;
    ArrayList<EdgeWithWt> adjList[] = null;

    PrimsAlgo(int V) {
        v = V;
        adjList = new ArrayList[V];

        for (int i=0;i<v;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        int n = 7;
        PrimsAlgo h = new PrimsAlgo(n);
        h.addEdge(0,1,10);
        h.addEdge(0,3,40);
        h.addEdge(1,0,10);
        h.addEdge(1,2,10);
        h.addEdge(2,1,10);
        h.addEdge(2,3,10);
        h.addEdge(3,0,40);
        h.addEdge(3,2,10);
        h.addEdge(3,4,2);
        h.addEdge(4,3,2);
        h.addEdge(4,5,3);
        h.addEdge(4,6,8);
        h.addEdge(5,4,3);
        h.addEdge(5,6,3);
        h.addEdge(6,4,8);
        h.addEdge(6,5,3);

        boolean[] visited = new boolean[n];
        h.primsAlgo(0, visited);
    }

    private void primsAlgo(int src, boolean[] visited) {

        PriorityQueue<Pair4> pq = new PriorityQueue<Pair4>();
        pq.add(new Pair4(src,-1, 0));

        while (!pq.isEmpty()) {
            Pair4 rem = pq.remove();

            if (visited[rem.v] == false) {
                visited[rem.v] = true;

                if (rem.v != -1) {
                    System.out.println(rem.v+"-"+rem.acv+"-"+ rem.wt);
                }

                ListIterator<EdgeWithWt> it = adjList[rem.v].listIterator();
                while (it.hasNext()) {
                    EdgeWithWt edge = it.next();
                    if (visited[edge.nbr] == false) {
                        pq.add(new Pair4(edge.nbr, edge.src, edge.wt));
                    }
                }
            }
        }
    }

    public void addEdge(int src, int dest, int wt) {
        adjList[src].add(new EdgeWithWt(src, dest, wt));
    }
}

class Pair4 implements Comparable<Pair4> {
    int v;
    int acv;
    int wt;

    public Pair4(int v, int acv, int wt) {
        this.v = v;
        this.acv = acv;
        this.wt = wt;
    }

    @Override
    public int compareTo(Pair4 o) {
        return this.wt - o.wt;
    }
}
