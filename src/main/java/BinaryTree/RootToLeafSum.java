package BinaryTree;

import java.util.ArrayList;

public class RootToLeafSum {

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(16);
        root.right = new BTNode(5);
        root.left.right = new BTNode(-3);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(11);

        ArrayList<Integer> a = new ArrayList<Integer>();
        boolean res = rootToLeaf(root, 26, a);
        System.out.println(res);
        System.out.println(a);
    }

    private static boolean rootToLeaf(BTNode root, int sum, ArrayList<Integer> res) {

        if(root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.data == sum) {
                res.add(root.data);
                return true;
            } else {
                return false;
            }
        }

        if (rootToLeaf(root.left,sum-root.data,res)) {
            res.add(root.data);
            return true;
        }

        if (rootToLeaf(root.right, sum- root.data,res)) {
            res.add(root.data);
            return true;
        }
        return false;
    }
}
