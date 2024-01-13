package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

    public static List<Integer> kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            if (pq.size() < k) {
                pq.add(val);
            }
            else {
                System.out.println("largest value in current window till k {} "+k+" is {}: "+ pq.peek());
                if (val > pq.peek()) {
                    pq.poll();
                    pq.add(val);
                }
            }

            if (pq.size() >= k) {
                list.add(pq.peek());
            } else {
                list.add(-1);
            }
        }
        System.out.println("current largest value : "+pq.peek());
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,15,7};
        List<Integer> res = kthLargest(arr, 4);

        for(int x : res) {
            System.out.println(x);
        }
    }
}
