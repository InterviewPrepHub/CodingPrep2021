package Array.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInEverySubArray {

    public static void main(String[] args) {
        int[] arr = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        maxOfEverySubArray(arr, k, arr.length);
    }

    private static void maxOfEverySubArray(int[] arr, int k, int n) {

        Deque<Integer> di = new LinkedList<>();

        for (int i=0;i<k;i++) {
            while (!di.isEmpty() && arr[i] >= arr[di.peekLast()]) {
                di.removeLast();
            }
            di.addLast(i);
        }

        for (int i=k;i<n;i++) {

            System.out.println(arr[di.peek()]);

            while (!di.isEmpty() && di.peek() <= i-k) {
                di.removeFirst();
            }

            while (!di.isEmpty() && arr[i] >= arr[di.peekLast()]) {
                di.removeLast();
            }
            di.addLast(i);
        }

        System.out.println(arr[di.peek()]);

    }
}
