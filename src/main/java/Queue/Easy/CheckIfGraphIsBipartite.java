package Queue.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfGraphIsBipartite {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] colors = new int[n];     // 0 -> not colored, 1 -> color1, -1 -> color2

        //try to colour each component
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                //start BFS from this node

                //define queue
                Queue<Integer> q = new LinkedList<>();
                q.offer(i); //i = 0 -> {1,2,3}
                colors[i] = 1; //colour the first node with color1

                while(!q.isEmpty()) {
                    int node = q.poll();

                    for (int neighbour : graph[node]) {
                        //check if the colour of node and the adjacent node is of same color then its not bipartite
                        if (colors[node] == colors[neighbour]) {
                            System.out.println("graph is not bipartite");
                            return false;
                        } else if(colors[neighbour] == 0){ //neighbour node is not colored
                            colors[neighbour] = -colors[node];  //colour the opposite color
                            q.add(neighbour);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /*
                0-------1
                |  \    |
                |    \  |
                |      \|
                3-------2

                for 0 -> connected vertices -> 1,2,3
                for 1 -> connected vertices -> 0,2
                for 2 -> connected vertices -> 0,1,2
                for 3 -> connected vertices -> 0,2
         */
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};

        CheckIfGraphIsBipartite c = new CheckIfGraphIsBipartite();
        System.out.println(c.isBipartite(graph));

    }
}
