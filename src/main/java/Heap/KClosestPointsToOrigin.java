package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=IEVbMb473q8

public class KClosestPointsToOrigin {

    public static int[][] closestToOrigin(int[][] points, int k) {

        if(points == null) {
            return null;
        }

        //create priority queue [minheap]
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2) -> (p1[0]*p1[0] + p1[1]*p1[1])- (p2[0]*p2[0]+p2[1]*p2[1]));
        // System.out.println(points.length);

        for(int i=0;i<points.length;i++) {
            pq.add(points[i]);
        }

        ArrayList<int[]> result = new ArrayList<>();
        while(k>0) {
            k--;
            result.add(pq.poll());
        }

        return result.toArray(new int[result.size()][k]);
    }


    public static void main(String[] args) {

        int[][] points = {{0,-3},{0,2},{5,1}};
        int[][] res = closestToOrigin(points, 2);
        System.out.println(res[0][0]);
        System.out.println(res[0][1]);
        System.out.println(res[1][0]);
        System.out.println(res[1][1]);
        // System.out.println(res[2][0]);

    }
}
