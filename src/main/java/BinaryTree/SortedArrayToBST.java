package BinaryTree;

public class SortedArrayToBST {

    public static void main(String[] args) {
        SortedArrayToBST s = new SortedArrayToBST();

        int[] arr = {1,2,3,4,5};
        s.createBST(arr,0,arr.length-1);
    }

    private BTNode createBST(int[] arr, int start, int end) {

        if(start > end) {
            return null;
        }

        int mid = (start+end)/2;
        BTNode root = new BTNode(arr[mid]);

        root.setLeft(createBST(arr, start, mid-1));
        root.setRight(createBST(arr,mid+1, end));

        return root;
    }


}
