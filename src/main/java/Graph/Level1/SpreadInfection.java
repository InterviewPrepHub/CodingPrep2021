package Graph.Level1;

import java.util.*;

public class SpreadInfection {

    int v;
    ArrayList<EdgeWOWt> adjList[] = null;

    SpreadInfection(int v) {
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
        SpreadInfection s = new SpreadInfection(n);
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
        s.infection(6, visited);
    }

    private void infection(int src, int[] visited) {
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(0, 1));
        int count = 0;

        while (!q.isEmpty()) {
            Pair2 rem = q.remove();

            if (visited[rem.v] > 0 ) {
                continue;
            } else {
                visited[rem.v] = rem.time;
                count++;
                ListIterator<EdgeWOWt> it = adjList[src].listIterator();
                while (it.hasNext()) {
                    EdgeWOWt edge = it.next();
                    if (visited[edge.nbr] < 0) {
                        q.add(new Pair2(edge.nbr, rem.time+1));
                    }

                }
            }

        }
        System.out.println(count);
    }

}

class Pair2 {
    int v;
    int time;

    public Pair2(int v, int time) {
        this.v = v;
        this.time = time;
    }
}