package Graph.Practise;

import Graph.Level1.EdgeWithWt;

import java.util.*;

public class Level1 {

    int v;
    List<EdgeWithWt>[] adjList;

    Level1(int v) {
        this.v = v;
        adjList = new ArrayList[v];

        for (int i=0;i<v;i++) {
            adjList[i] = new ArrayList<EdgeWithWt>();
        }
    }

//        40     2
//    0------3--------4
//    |      |       |  \
//  10|    10|     3 |   \ 8
//    1------2       5----6
//       10            3

    public static void main(String[] args) {
        Level1 l = new Level1(7);
        l.addEdge(0,1,10);
        l.addEdge(1,0,10);
        l.addEdge(0,3,40);
        l.addEdge(3,0,40);
        l.addEdge(1,2,10);
        l.addEdge(2,1,10);
        l.addEdge(2,3,10);
        l.addEdge(3,2, 10);
        l.addEdge(3,4,2);
        l.addEdge(4,3,2);
        l.addEdge(4,5,3);
        l.addEdge(5,4,3);
        l.addEdge(5,6,3);
        l.addEdge(6,5,3);
        l.addEdge(4,6,8);
        l.addEdge(6,4,8);

        l.hasPath(1,5);
        
        l.printAllPaths(1, 5);

//        0       2        4
//        |       |       |  \
//        |       |       |   \
//        1       3       5----6
        Level1 l1 = new Level1(7);
        l1.addEdge(0,1,10);
        l1.addEdge(1,0,10);
        l1.addEdge(2,3,10);
        l1.addEdge(3,2, 10);
        l1.addEdge(4,5,3);
        l1.addEdge(5,4,3);
        l1.addEdge(5,6,3);
        l1.addEdge(6,5,3);
        l1.addEdge(4,6,8);
        l1.addEdge(6,4,8);

        l1.connectedGraphs();

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid1 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        l.numberOfIslands(grid1);
    }

    private void numberOfIslands(char[][] grid) {

        if (grid.length == 0 || grid==null) {
            System.out.println(0);
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count=0;

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numberOfIslands(grid,i,j,visited);
                    count++;
                }
            }
        }

        System.out.println("no of islands : "+count);
    }

    private void numberOfIslands(char[][] grid, int i, int j, boolean[][] visited) {

        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || visited[i][j] || grid[i][j]=='0') {
            return;
        }

        visited[i][j] = true;

        numberOfIslands(grid, i+1,j,visited);
        numberOfIslands(grid, i,j+1,visited);
        numberOfIslands(grid, i,j-1,visited);
        numberOfIslands(grid, i-1,j,visited);
    }

    private void connectedGraphs() {
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for (int i=0;i<v;i++) {
            ArrayList<Integer> comp;
            if (visited[i] == false) {
                comp = new ArrayList<>();
                comp.add(i);
                generateList(i, visited, comp, components);
                components.add(comp);
            }
        }

        System.out.println(components);
    }

    private void generateList(int src, boolean[] visited, ArrayList<Integer> comp, ArrayList<ArrayList<Integer>> components) {

        visited[src] = true;

        ListIterator<EdgeWithWt> result = adjList[src].listIterator();

        while (result.hasNext()) {
            EdgeWithWt edge = result.next();
            if (visited[edge.nbr]==false) {
                comp.add(edge.nbr);
                generateList(edge.nbr, visited,comp,components);
            }
        }
    }

    private void printAllPaths(int src, int dest) {
        boolean[] visited = new boolean[v];
        printAllPaths(src, dest, visited, src+"");
    }

    private void printAllPaths(int src, int dest, boolean[] visited, String psf) {

        if (src==dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;

        ListIterator<EdgeWithWt> result = adjList[src].listIterator();

        while(result.hasNext()) {
            EdgeWithWt edge = result.next();
            if (visited[edge.nbr]==false) {
                printAllPaths(edge.nbr, dest, visited, psf+edge.nbr);
            }
        }
        visited[src] = false;
    }

    private void hasPath(int src, int dest) {
        boolean[] visited = new boolean[v];
        boolean hasPathResult = hasPath(src, dest, visited);
        System.out.println(hasPathResult);
    }

    private boolean hasPath(int src, int dest, boolean[] visited) {

        if (src==dest) {
            return true;
        }

        visited[src] = true;

        ListIterator<EdgeWithWt> result = adjList[src].listIterator();

        while (result.hasNext()) {
            EdgeWithWt edge = result.next();

            if (visited[edge.nbr]==false) {
                boolean resultPath = hasPath(edge.nbr, dest, visited);
                if (resultPath == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addEdge(int u, int v, int wt) {
        adjList[u].add(new EdgeWithWt(u,v,wt));
    }
}
