package BinaryTree;

public class CreateBST {

    static BTNode createBST(int[] arr, int start, int end) {

        if(start > end) {
            return null;
        }
        int mid = (start+end)/2;
        BTNode root = new BTNode(arr[mid]);

        root.setLeft(createBST(arr, start, mid-1));
        root.setRight(createBST(arr,mid+1, end));

        return root;

    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr = {3, 18, 8, 10, 12};
        BTNode node = createBST(arr, 0, arr.length-1);
        inorderTraversal(node);
    }

    private static void inorderTraversal(BTNode node) {

        if (node.left != null) {
            inorderTraversal(node.left);
        }
        System.out.println(node.data);
        if (node.right != null) {
            inorderTraversal(node.right);
        }
    }
}
