package BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

public class KthLargestInBST {

    public static void main(String[] args) {
        BTNode node = new BTNode(10);
        node.left = new BTNode(7);
        node.right = new BTNode(12);
        node.left.left = new BTNode(5);
        node.left.right = new BTNode(9);
        node.left.right.left = new BTNode(8);
        node.right.right = new BTNode(13);
        int k = 2;
        BTNode res = kthLargest(node, k);
        System.out.println(res.data);
    }

    // Function to find the k'th largest node in the BST
    public static BTNode kthLargest(BTNode root, int k) {
        // maintain index to count the total number of nodes processed so far
        AtomicInteger i = new AtomicInteger(0);

        // traverse the tree in an inorder fashion and return k'th node
        return kthLargest(root, i, k);
    }

    public static BTNode kthLargest(BTNode root, AtomicInteger i, int k)
    {
        // base case
        if (root == null) {
            return null;
        }

        // search in the right subtree
        BTNode right = kthLargest(root.right, i, k);

        // if k'th largest is found in the right subtree, return it
        if (right != null) {
            return right;
        }

        // if the current node is k'th largest, return its value
        if (i.incrementAndGet() == k) {
            System.out.println(i +"--" +k);
            return root;
        }

        // otherwise, search in the left subtree
        return kthLargest(root.left, i, k);
    }

}
