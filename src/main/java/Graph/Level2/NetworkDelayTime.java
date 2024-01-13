package Graph.Level2;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.PriorityQueue;

/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges
times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to
travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

*/

public class NetworkDelayTime {

    int nodes;

    ArrayList<Times> adjList[];

    NetworkDelayTime(int v) {
        this.nodes = v;
        adjList = new ArrayList[v];

        for (int i=0;i<v;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int v = 5;
        NetworkDelayTime n = new NetworkDelayTime(v);
//        n.addEdge(2,1,1);
//        n.addEdge(2,3,1);
//        n.addEdge(3,4,1);
        n.addEdge(1,2,1);

        boolean[] visited = new boolean[v];
        int src = 1;
        n.DA(src, visited, "");
    }

    private void DA(int src, boolean[] visited, String psf) {

        int total_wt = 0;
        PriorityQueue<Data> p = new PriorityQueue<>();
        p.add(new Data(src, 0, psf+src));

        while (!p.isEmpty()) {
            Data rem = p.remove();

            if (visited[rem.v] == true) {
                continue;
            } else {
                visited[rem.v] = true;
                System.out.println(rem.v + "via" + rem.psf + "@" + rem.wt);

                ListIterator<Times> it = adjList[rem.v].listIterator();

                while (it.hasNext()) {
                    Times n = it.next();
                    if (visited[n.nbr] == false) {
                        total_wt+=rem.wt+n.wt;
                        if (rem.psf.charAt(0) == 2) {
                            p.add(new Data(n.nbr, rem.wt+n.wt, rem.psf+n.nbr));
                        }
                    }
                }
            }
        }

        System.out.println(total_wt);

    }

    private void addEdge(int u, int v, int w) {
        adjList[u].add(new Times(u,v,w));
    }
}

class Times {
    int src;
    int nbr;
    int wt;

    Times(int src, int nbr, int wt) {
        this.src = src;
        this.nbr = nbr;
        this.wt = wt;
    }
}

class Data implements Comparable<Data> {
    int v;
    int wt;
    String psf;

    public Data(int v, int wt, String psf) {
        this.v = v;
        this.wt = wt;
        this.psf = psf;
    }


    @Override
    public int compareTo(Data o) {
        return this.wt - o.wt;
    }
}
