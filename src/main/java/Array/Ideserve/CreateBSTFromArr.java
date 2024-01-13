package Array.Ideserve;

/**
 * Given a sorted integer array of length n, create a balanced Binary Search Tree using elements of the array.
 *
 * A binary tree is balanced if diff in ht of left subtree & right subtree is 1.
 */

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class CreateBSTFromArr {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        Node node = createBST(arr,0, arr.length-1);

        inOrderTraversal(node);

    }

    private static void inOrderTraversal(Node node) {
        if (node==null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    private static Node createBST(int[] arr, int low, int high) {

        if (low > high) {
            return null;
        }
        int mid = (high-low)/2 + low;

        Node root = new Node(arr[mid]);
        root.left = createBST(arr,low,mid-1);
        root.right = createBST(arr,mid+1, high);
        return root;
    }
}
