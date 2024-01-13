package Array.SlidingWindow;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NegativeNumberInEveryWindow {

    public static void main(String[] args) {
        int arr[] = {10, -1, -5, 7, -15, 20, 18, 24} , k = 3;

        firstNegativeNum(arr, k);
    }

    private static void firstNegativeNum(int[] arr, int k) {

        int n = arr.length;
        int[] firstNegNum = new int[n];
        int idx = 0;

        Queue<Integer> q = new LinkedList<>();
        int windowStart = 0;

        for (int windowEnd=0;windowEnd<n;windowEnd++) {
            if(arr[windowEnd] < 0) {
                q.add(arr[windowEnd]);
            }

            if (windowEnd-windowStart+1 == k) {
                if (q.isEmpty()) {
                    firstNegNum[idx++] = 0;
                } else {
                    int num = q.peek();
                    firstNegNum[idx] = num;
                    idx++;

                    if(num == arr[windowStart]) {
                        q.remove();
                    }
                }
                windowStart++;
            }

        }

        for (int a : firstNegNum) {
            System.out.println(a);
        }
    }

}
