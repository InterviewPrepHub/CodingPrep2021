package BinaryTree;

import BinaryTree.BTNode;

public class AllAncestorsOfNode {

    public static void main(String[] args) {
        BTNode node = new BTNode(1);
        node.left = new BTNode(2);
        node.left.left = new BTNode(4);
        node.left.right = new BTNode(5);
        node.left.right.left = new BTNode(7);
        node.left.right.right = new BTNode(8);
        node.right = new BTNode(3);

        AllAncestorsOfNode a = new AllAncestorsOfNode();
        a.ancestorsOfNode(node, new BTNode(8));
    }

    private boolean ancestorsOfNode(BTNode root, BTNode target) {

        if (root==null) {
            return false;
        }

        if (root.data == target.data) {
            return true;
        }

        boolean left = ancestorsOfNode(root.left, target);
        boolean right = false;
        if (!left) {
            right = ancestorsOfNode(root.right, target);
        }

        if (left || right) {
            System.out.println(root.data);
        }
        return left || right;
    }
}
