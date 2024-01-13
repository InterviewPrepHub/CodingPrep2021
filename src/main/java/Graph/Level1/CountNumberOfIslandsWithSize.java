package Graph.Level1;

import java.util.ArrayList;

public class CountNumberOfIslandsWithSize {
    static int count;

    public static void main(String[] args) {
        int graph [][] =  new int[][] {

                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}


                /*{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}*/
        };

        countIslandsAndSize(graph);
    }

    private static void countIslandsAndSize(int[][] graph) {

        boolean[][] visited = new boolean[graph.length][graph[0].length];
        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int i=0;i<graph.length;i++) {
            for (int j=0;j<graph[0].length;j++) {
                if(graph[i][j] == 1 && !visited[i][i]) {
                    count = 1;
                    count = DFS(graph, i, j, visited);
                    ans.add(DFS(graph, i, j, visited));
                    System.out.println("size of island : "+count);
                    if (max < count) {
                        max = count;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static int DFS(int[][] graph, int i, int j, boolean[][] visited) {
//        int[] ROW = new int[]{-1,-1,-1,0,1,1,1};
//        int[] COL = new int[]{-1,0,1,1,1,0,-1,1};
//                    0
//                0   1   0
//                    0

        int[] ROW = {0,1,-1,0};
        int[] COL = {1,0,0,-1};
        visited[i][j] = true;
        for (int m=0;m<ROW.length;m++) {
            int row = i+ROW[m];
            int col = j+COL[m];
            if(row >= 0 && row < graph.length && col >= 0 && col < graph[0].length && visited[row][col] == false && graph[row][col] == 1) {
                count+=DFS(graph, row, col, visited);
            }
        }

        return count;
    }

}
