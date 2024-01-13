package Graph.Level1;

import java.util.ArrayList;
import java.util.ListIterator;

public class IsGraphConnected {

    int v;
    ArrayList<EdgeWOWt> adjList[] = null;

    IsGraphConnected(int V) {
        v = V;
        adjList = new ArrayList[V];

        for (int i=0;i<v;i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest) {
        adjList[src].add(new EdgeWOWt(src, dest));
    }

    public static void main(String[] args) {
        int n = 7;
        IsGraphConnected s = new IsGraphConnected(n);
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

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for (int i=0;i<n;i++) {
            ArrayList<Integer> comp = null;
            if (visited[i] == false) {
                comp = new ArrayList<>();
                comp.add(i);
                s.generateList(i, visited, comp);
                components.add(comp);
            }

        }

        System.out.println(components);
        if (components.size() > 1) {
            System.out.println("graph is not connected");
        } else {
            System.out.println("graph is connected");
        }
    }

    private void generateList(int src, boolean[] visited, ArrayList<Integer> comp) {
        visited[src] = true;
        ListIterator<EdgeWOWt> it = adjList[src].listIterator();
        while (it.hasNext()) {
            EdgeWOWt edge = it.next();
            if (visited[edge.nbr] == false) {
                comp.add(edge.nbr);
                generateList(edge.nbr, visited,comp);
            }
        }
    }

}
