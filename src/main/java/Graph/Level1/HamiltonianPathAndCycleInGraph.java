package Graph.Level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;

/*

Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in the graph) from the last vertex to the first vertex of the Hamiltonian Path. Determine whether a given graph contains Hamiltonian Cycle or not. If it contains, then prints the path. Following are the input and output of the required function.
Input:
A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph. A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.
Output:
An array path[V] that should contain the Hamiltonian Path. path[i] should represent the ith vertex in the Hamiltonian Path. The code should also return false if there is no Hamiltonian Cycle in the graph.
For example, a Hamiltonian Cycle in the following graph is {0, 1, 2, 4, 3, 0}.

(0)--(1)--(2)
 |   / \   |
 |  /   \  |
 | /     \ |
(3)-------(4)
And the following graph doesn’t contain any Hamiltonian Cycle.

(0)--(1)--(2)
 |   / \   |
 |  /   \  |
 | /     \ |
(3)      (4)

 */
public class HamiltonianPathAndCycleInGraph {

    static int v;
    ArrayList<EdgeWithWt> adj[] = null;

    HamiltonianPathAndCycleInGraph(int V) {
        v = V;
        adj = new ArrayList[V];
        for (int i=0;i<V;i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        HamiltonianPathAndCycleInGraph h = new HamiltonianPathAndCycleInGraph(4);

        h.addEdge(0,1,2);
        h.addEdge(0,2,2);
        h.addEdge(1,0,2);
        h.addEdge(1,3,1);
        h.addEdge(2,0,2);
        h.addEdge(2,1,1);
        h.addEdge(2,3,2);
        h.addEdge(3,1,1);
        h.addEdge(3,2,2);

        HashSet<Integer> visited = new HashSet<>();

        h.findCycleExistsInGraph(0,visited,0+"", 0);
    }

    private void findCycleExistsInGraph(int src, HashSet<Integer> visited, String psf, int origSrc) {

        if (visited.size() == adj.length-1) {
            System.out.println(psf);

            //also check the cycle or not

            //traverse again through list iterator
            ListIterator<EdgeWithWt> edgeList = adj[src].listIterator();
            boolean closingEdgeFound = false;
            while (edgeList.hasNext()) {
                EdgeWithWt edge = edgeList.next();
                if (edge.nbr == origSrc) {
                    closingEdgeFound = true;
                }
            }

            if (closingEdgeFound == true) {
                System.out.println("cycle exists");
            } else {
                System.out.println("cycle does not exists");
            }

        }

        visited.add(src);
        ListIterator<EdgeWithWt> edgeList = adj[src].listIterator();

        while (edgeList.hasNext()) {
            EdgeWithWt edge = edgeList.next();
            if (visited.contains(edge.nbr) == false) {
                findCycleExistsInGraph(edge.nbr, visited, psf+edge.nbr, origSrc);
            }
        }
        visited.remove(src);


    }

    private void addEdge(int src, int nbr, int wt) {
        adj[src].add(new EdgeWithWt(src,nbr,wt));
    }
}
