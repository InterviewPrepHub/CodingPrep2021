package Heap;

public class kthSmallestInArray {
    int size = 0;

    public static void main(String[] args) {

        int[] a = {10,50,40,75,60,65,45};
        int len = a.length-1;

        kthSmallestInArray s = new kthSmallestInArray();
        s.add(a);
        for (int i=0;i< a.length;i++) {
            System.out.print(a[i] + " ");
        }
        }

    private void add(int[] a) {
        int item = a[size]; //10
        size++; //1

        heapifyUp(a);
    }

    private void heapifyUp(int[] a) {
        int index = size-1;
        int item = a[index];

        while(hasParent(index) && parent(index,a) > item) {
//            swap(getParentIndex(index), index);
            //move up
            index = getParentIndex(index);
        }
    }

    private void swap(int[] a, int parentIndex, int current) {
        int temp = a[current];
        a[current] = a[parentIndex];
        a[parentIndex] = temp;
    }

    public int parent(int index,int[] a) {
        return a[getParentIndex(index)];
    }

    public int leftChild(int index, int[] a) {
        return a[getLeftIndex(index)];
    }

    public int rightChild(int index, int[] a) {
        return a[getRightIndex(index)];
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public boolean hasLeftChild(int index) {
        return getLeftIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightIndex(index) < size;
    }

    public int getLeftIndex(int index) {
        return 2*index+1;
    }

    public int getRightIndex(int index) {
        return 2*index+2;
    }

    public int getParentIndex(int index) {
        return (index-1)/2;
    }

}
