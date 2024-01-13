package Graph.Level1;

import java.util.ArrayList;
import java.util.ListIterator;

public class PrintAllPathsWithWeights {

    int v;
    ArrayList<EdgeWithWt> adjList[] = null;

    PrintAllPathsWithWeights(int V) {
        v = V;
        adjList = new ArrayList[V];

        for (int i=0;i<v;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        PrintAllPathsWithWeights h = new PrintAllPathsWithWeights(n);

        h.addEdge(0,1,2);
        h.addEdge(0,2,2);
        h.addEdge(1,0,2);
        h.addEdge(1,3,1);
        h.addEdge(2,0,2);
        h.addEdge(2,1,1);
        h.addEdge(2,3,2);
        h.addEdge(3,1,1);
        h.addEdge(3,2,2);

        boolean[] visited = new boolean[n];
        h.printAllPathsWithWts(0, 3, visited, "0", 0);
    }

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MAX_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static int criteria = 3;
    private void printAllPathsWithWts(int src, int dest, boolean[] visited, String psf, int wtSoFar) {

        if (src == dest) {
            if (wtSoFar < spathwt) {
                spathwt = wtSoFar;
                spath = psf;
            }

            if (wtSoFar > lpathwt) {
                lpathwt = wtSoFar;
                lpath = psf;
            }

            if(wtSoFar > criteria && wtSoFar < cpathwt ){

            }


            System.out.println(psf+"@"+wtSoFar);
            return;
        }

        visited[src] = true;
        ListIterator<EdgeWithWt> edgeList = adjList[src].listIterator();
        while(edgeList.hasNext()) {
            EdgeWithWt edge = edgeList.next();
            if (visited[edge.nbr] == false) {
                printAllPathsWithWts(edge.nbr, dest, visited, psf+edge.nbr, wtSoFar+ edge.wt);
            }
        }
        visited[src] = false;

    }

    public void addEdge(int src, int dest, int wt) {
        adjList[src].add(new EdgeWithWt(src, dest, wt));
    }

}
