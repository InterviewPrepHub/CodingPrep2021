package Sorting;

import java.util.Iterator;
import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {

        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i=0;i<k+1;i++) {
            pq.add(arr[i]); // pq -> 2,3,4,6
        }

        int index = 0;
        for (int j=k+1;j<n;j++) {
            arr[index] = pq.peek(); //[2,5,3,2,8,10,9]
            index++;
            pq.poll();  //[3,5,6]
            pq.add(arr[j]); //[3,5,6,8], [5,6,8,10], [6,8,10,9]
        }

        Iterator itr = pq.iterator();
        while (itr.hasNext()) {
            arr[index] = pq.peek();
            index++;
            pq.poll();
        }

        printArray(arr);

    }

    public static void printArray(int[] a1) {
        for(int i=0;i<a1.length;i++) {
            System.out.println(a1[i]);
        }
    }
}
