package Array.Ideserve;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Maximum element from each subarray of size k
 */
public class MaxElementInEachSubArr {

    public static void main(String[] args) {

        int[] arr = {9,6,11,8,10,5,4,13,93,14};
        int k = 4;

        maxElement(arr, k);

    }

    private static void maxElement(int[] arr, int k) {

        int windowStart = 0;
        int n = arr.length;
        int[] result = new int[n-k+1];
        int idx = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());

        for (int windowEnd=0;windowEnd<n;windowEnd++) {
            p.add(arr[windowEnd]);

            if (windowEnd-windowStart+1==k) {
                int maxElement = p.peek();
                result[idx] = maxElement;
                idx++;

                if (maxElement == arr[windowStart]) {
                    p.remove();
                }

                windowStart++;
            }
        }
    }

}
