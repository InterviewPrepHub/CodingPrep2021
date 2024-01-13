package Graph.Level1;

import java.util.ArrayList;
import java.util.ListIterator;

public class GetConnectedComponents {

    int v;
    ArrayList<EdgeWithWt> adjList[] = null;

    GetConnectedComponents(int V) {
        v = V;
        adjList = new ArrayList[V];

        for (int i=0;i<v;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        int n = 7;
        GetConnectedComponents h = new GetConnectedComponents(n);

//        0       2        4
//        |       |       |  \
//        |       |       |   \
//        1       3       5----6

        h.addEdge(0,1,2);
//        h.addEdge(0,2,2);
        h.addEdge(1,0,2);
//        h.addEdge(1,3,1);
//        h.addEdge(2,0,2);
//        h.addEdge(2,1,1);
        h.addEdge(2,3,2);
//        h.addEdge(3,1,1);
        h.addEdge(3,2,2);
        h.addEdge(4,5,2);
        h.addEdge(4,6,2);
        h.addEdge(5,4,2);
        h.addEdge(5,6,2);
        h.addEdge(6,4,2);
        h.addEdge(6,5,2);

        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++) {
            ArrayList<Integer> comps = null;
            if(visited[i] == false) {
                comps = new ArrayList<>();
                comps.add(i);
                h.generateList(i, visited, comps, components);
                components.add(comps);
            }

        }

        System.out.println("test");
        for(ArrayList<Integer> list : components) {
            for (Integer l : list) {
                System.out.print(l+" ");
            }
            System.out.println();
        }

    }

    public void addEdge(int src, int dest, int wt) {
        adjList[src].add(new EdgeWithWt(src, dest, wt));
    }

    private void generateList(int src, boolean[] visited, ArrayList<Integer> comps, ArrayList<ArrayList<Integer>> components) {

        visited[src] = true;

        ListIterator<EdgeWithWt> list = adjList[src].listIterator();
        while (list.hasNext()) {
            EdgeWithWt edge = list.next();
            if (visited[edge.nbr] == false) {
                comps.add(edge.nbr);
                generateList(edge.nbr, visited, comps, components);
            }
        }
    }
}
