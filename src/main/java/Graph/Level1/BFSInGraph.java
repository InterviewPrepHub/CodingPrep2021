package Graph.Level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class BFSInGraph {

    int v;
    ArrayList<EdgeWOWt> adj[];

    public BFSInGraph(int V) {
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
        int n = 7;
        BFSInGraph b = new BFSInGraph(n);
        b.addEdge(0,1);
        b.addEdge(0,3);
        b.addEdge(1,0);
        b.addEdge(1,2);
        b.addEdge(2,1);
        b.addEdge(2,3);
        b.addEdge(3,0);
        b.addEdge(3,2);
        b.addEdge(3,4);
        b.addEdge(4,3);
        b.addEdge(4,5);
        b.addEdge(4,6);
        b.addEdge(5,4);
        b.addEdge(5,6);
        b.addEdge(6,4);
        b.addEdge(6,5);

        b.bfsGraph(2);
        
    }


    private void bfsGraph(int src) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];

        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            //  remove mark* work add*
            Integer rem = q.poll();    //remove
            System.out.println(rem); //work

            ListIterator<EdgeWOWt> it = adj[rem].listIterator();
            while (it.hasNext()) {
                EdgeWOWt edge = it.next();
                if (visited[edge.nbr] == false) {
                    visited[edge.nbr] = true;
                    q.add(edge.nbr);  //add
                }
            }
        }

    }

}
