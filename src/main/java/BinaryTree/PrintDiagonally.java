package BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class PrintDiagonally {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);

        PrintDiagonally p = new PrintDiagonally();
        p.diagonalPrint(root);
    }

    public static void diagonalPrint(BTNode root) {
        // create an empty queue
        Queue<BTNode> q = new ArrayDeque<>();

        // create a dummy (dummy) node to denote the end of a diagonal
        BTNode dummy = new BTNode(-1);

        // enqueue all nodes of the first diagonal in the binary tree
        while (root != null) {
            q.add(root);
            root = root.right;
        }

        // enqueue dummy node at the end of each diagonal
        q.add(dummy);

        // run till the only dummy is left
        while (!q.isEmpty()) {
            // dequeue front node
            BTNode front = q.poll();

            if (front != dummy) {
                // print the current node
                System.out.print(front.data + " ");

                // enqueue nodes of the next diagonal in the binary tree
                BTNode node = front.left;
                while (node != null) {
                    q.add(node);
                    node = node.right;
                }
            }
            else {
                // If the current diagonal end is reached, enqueue the dummy node and print an empty line
                q.add(dummy);
                System.out.println();
            }
        }
    }
}
