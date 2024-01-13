package BinaryTree;

import java.util.ArrayList;
import java.util.List;


/**
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that
 * their sum is equal to the given target.
 */
public class TwoSumInBST {

    public static void main(String[] args) {
        BTNode root1 = new BTNode(5);
        root1.left = new BTNode(3);
        root1.left.left = new BTNode(2);
        root1.left.right = new BTNode(4);
        root1.right = new BTNode(6);
        root1.right.right = new BTNode(7);

        TwoSumInBST t = new TwoSumInBST();

        boolean res = t.findTarget(root1,9);
        System.out.println(res);
    }

    List<Integer> list = new ArrayList<>();

    public boolean findTarget(BTNode root, int k) {
        if(root == null) {
            return false;
        }

        int diff = k-root.data;

        if(list.contains(diff)) {
            System.out.println(diff+"  "+ root.data);
            return true;
        } else {
            list.add(root.data);
        }
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}
