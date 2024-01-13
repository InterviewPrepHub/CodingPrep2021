package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianInAStream {


    /*
    mean -> average
    median -> middle in a sorted order
    mode -> most common number

    so keep the array formed from incoming data in sorted order
    10 <- 10
    8 10 <- 8
    8 9 10  <- 9

    keep the incoming numbers in two buckets
    one with lower half & one with upper half

    if the size of bucket is same then find avg of lower half max & upper half min
    if the size is different then get bigger element from max of lower & min of higher

    so keep two heaps -> max heap for lowers part of numbers with the biggest element in top
    & min heap for the upper part of numbers with smallest element in top
     */

    public double[] getMedians(int[] arr) {

        //create max heap for lower half
        PriorityQueue<Integer> lower = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        //create min heap for higher half
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        double[] medians = new double[arr.length];

        for (int i=0;i<arr.length;i++) {
            addNumber(arr[i], lower, higher);
            rebalanceHeap(lower, higher);
            medians[i] = getMedians(lower, higher);
        }

        return medians;

    }

    public void addNumber(int num, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if(lower.isEmpty() || num < lower.peek()) {
            lower.add(num); //8
        } else {
            higher.add(num);
        }
    }

    public void rebalanceHeap(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;

        if (biggerHeap.size() - smallerHeap.size()  >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public double getMedians(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;

        if (biggerHeap.size() == smallerHeap.size()) {
            return (double) (biggerHeap.size() + smallerHeap.size()) / 2;
        } else {
            return biggerHeap.peek();
        }

    }

    public static void main(String[] args) {
        FindMedianInAStream f = new FindMedianInAStream();
        int[] a = {8,10,9};
        double[] res = f.getMedians(a);
        for(double i : res) {
            System.out.println(i);
        }

    }
}
