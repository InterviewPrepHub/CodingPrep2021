package Graph.Level1;

import java.util.*;

/*
A Bipartite Graph is a graph whose vertices can be divided into two independent sets.

Divide vertices into two mutually exclusive & exhaustive sets such that all edges formed are across sets.

        0-------2
        |       |
        |       |
        1-------3


        s1          s2
        0           1
        3           2


This kind of looks like an extension to cyclic graph problem.
Every non cyclic graph is bipartite but if your cycle is of
odd length then it cannot be a bipartite.

          4
         | \
        |   \
       5-----6

       s1       s2
       4        6
       5 (cannot happen since 4 & 5 should e across sets)
 */
public class IsGraphBipartite {

    int v;
    ArrayList<EdgeWOWt> adjList[] = null;

    IsGraphBipartite(int v) {
        this.v = v;
        adjList = new ArrayList[v];

        for (int i=0;i<v;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    private void addEdge(int src, int dest) {
        adjList[src].add(new EdgeWOWt(src, dest));
    }

    public static void main(String[] args) {

        int n = 7;
        IsGraphBipartite s = new IsGraphBipartite(n);
        s.addEdge(0,1);
        s.addEdge(0,3);
        s.addEdge(1,0);
        s.addEdge(1,2);
        s.addEdge(2,1);
        s.addEdge(2,3);
        s.addEdge(3,0);
        s.addEdge(3,2);
        s.addEdge(3,4);
        s.addEdge(4,3);
        s.addEdge(4,5);
        s.addEdge(4,6);
        s.addEdge(5,4);
        s.addEdge(5,6);
        s.addEdge(6,4);
        s.addEdge(6,5);

        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        for (int i=0;i<n;i++) {
            if (visited[i] == -1) {
                boolean isbipartite = s.isBipatite(i, visited, "");
            }

        }
    }

    private boolean isBipatite(int src, int[] visited, String psf) {
        Queue<Pair1> q = new LinkedList<>();
        q.add(new Pair1(src, src+"", 0));

        while (!q.isEmpty()) {
            Pair1 rem = q.remove();

            if (visited[rem.v] != -1) {
                //check if the vertex is getting visited
                // if the vertex is getting visited @ same level then its an even cycle [its is bipartite]
                //else its an odd cycle

                if (rem.level != visited[rem.level]) {
                    return false;
                }
            }

            visited[rem.v] = rem.level;

            ListIterator<EdgeWOWt> it = adjList[src].listIterator();
            while (it.hasNext()) {
                EdgeWOWt edge = it.next();
                if (visited[edge.nbr] == -1) {
                    q.add(new Pair1(edge.nbr, edge.nbr+psf, rem.level+1));
                }
            }

        }
        return true;
    }
}

class Pair1 {
    int v;
    String psf;
    int level;

    Pair1(int v, String psf, int level) {
        this.v = v;
        this.psf = psf;
        this.level = level;
    }
}
