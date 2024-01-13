package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class ImplementHeap {

    private static int size=0;
    private static int capacity=10;
    private static int[] items = new int[capacity];

    //get Indexes
    private int getLeftChildIndex(int parentIndex) {
        return (2*parentIndex)+1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (2*parentIndex)+2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex-1)/2;
    }

    //find if it has child & parent
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    //get item
    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    public void add(int item) {
        ensureCapacity();
        // add the new item
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {

        //starts with the very last element
        int index = size - 1;
        int item = items[size-1];

        while(hasParent(index) && parent(index) > item) {
            swap(getParentIndex(index), index);
            //move up
            index = getParentIndex(index);
        }
    }


    //extract & removes the min element from array
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        //take the first element & remove
        int index = 0;
        int item = items[index];

        //take the last element & add to first
        items[0] = items[size-1];

        size--;
        heapifyDown();

        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);

            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            }
            swap(smallerChildIndex, index);
            index = smallerChildIndex;
        }

    }

    private void ensureCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity*2);
            capacity = capacity*2;
        }
    }

    private void swap(int parentIndex, int current) {
        int temp = items[current];
        items[current] = items[parentIndex];
        items[parentIndex] = temp;
    }

    public static void main(String[] args) {
        ImplementHeap heap = new ImplementHeap();
        heap.add(50);
        heap.add(10);
        heap.add(40);
        heap.add(75);
        heap.add(60);
        heap.add(65);
        heap.add(45);

        for(int i=0;i<3;i++) {
            int es1 = heap.poll();
            System.out.println(es1);
        }

//        int es1 = heap.poll();
//        System.out.println(es1);
//        int es2 = heap.poll();
//        System.out.println(es2);
//        int es3 = heap.poll();
//        System.out.println(es3);
//        printArray(items);
    }

    private static void printArray(int[] items) {
        for (int i=0;i<items.length;i++) {
            System.out.println(items[i]);
        }
    }
}
