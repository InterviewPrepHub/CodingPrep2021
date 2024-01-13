package Heap;

import java.util.PriorityQueue;

public class MergeKArrays {

    public static void main(String[] args) {
        int[][] grid = {{1,3,4}, {1,4,5}, {2,6,8}};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int row=0; row < grid.length; row++)
        {
            for (int col=0; col < grid[row].length; col++)
            {
                int value = grid[row][col];
                minHeap.add(value);
            }
        }

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

    }
}
