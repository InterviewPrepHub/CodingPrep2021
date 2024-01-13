package BinaryTree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CreateBSTFromBT {

    public static void main(String[] args) {

//                8
//           3          5
//       10     2    4     6

        BTNode root = new BTNode(8);
        root.left = new BTNode(3);
        root.right = new BTNode(5);
        root.left.left = new BTNode(10);
        root.left.right = new BTNode(2);
        root.right.left = new BTNode(4);
        root.right.right = new BTNode(6);
        convertToBST(root);
        inorderTraversal(root);
    }

    private static void convertToBST(BTNode root) {
        Set<Integer> set = new TreeSet<>();

        extractKeys(root, set);

        Iterator<Integer> it = set.iterator();

        convertToBST(root, it);
    }

    private static void convertToBST(BTNode root, Iterator<Integer> it) {

        if (root == null) {
            return ;
        }

        convertToBST(root.left, it);
        root.data = it.next();
        convertToBST(root.right, it);
    }

    private static void extractKeys(BTNode root, Set<Integer> set) {

        if (root == null) {
            return ;
        }

        extractKeys(root.left, set);
        set.add(root.data);
        extractKeys(root.right, set);
    }


    private static void inorderTraversal(BTNode node) {

        if (node.left != null) {
            inorderTraversal(node.left);
        }
        System.out.print(node.data +" ");
        if (node.right != null) {
            inorderTraversal(node.right);
        }
    }
}
