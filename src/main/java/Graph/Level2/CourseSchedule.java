package Graph.Level2;

import java.util.*;

public class CourseSchedule {

    static int numCourses;
    static List<Integer> edges[];

    CourseSchedule(int numCourses) {
        this.numCourses = numCourses;
        edges = new ArrayList[numCourses];

        for (int i=0;i<numCourses;i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdges(int u, int v) {
        edges[u].add(v);
    }


    public static void main(String[] args) {
        CourseSchedule t = new CourseSchedule(4);

        int[][] arr = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };

        /*for (int i=0;i<arr.length;i++) {
            int[] sub = arr[i];
            t.addEdges(sub[0], sub[1]);
        }*/

        for (int[] sub : arr) {
            t.addEdges(sub[0],sub[1]);
        }

//        for (int k=0;k<edges.length;k++) {
//            System.out.println(edges[k]);
//        }

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<numCourses;i++) {
            if (visited[i] == false) {
                t.topological(i, visited, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    public void topological(int src, boolean[] visited, Stack<Integer> st) {

        visited[src] = true;
        ListIterator<Integer> it = edges[src].listIterator();
        while (it.hasNext()) {
            int i = it.next();
            if (visited[i] == false) {
                topological(i, visited, st);
            }
        }
        st.push(src);
    }
}
