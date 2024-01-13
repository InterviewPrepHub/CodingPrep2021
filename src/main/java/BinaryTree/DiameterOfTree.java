package BinaryTree;

import java.util.ArrayList;

/*
The diameter of a binary tree is the length of the longest path between any two nodes of the tree.
The length is the number of edges in the path. The path may or may not include the root node.
 */
public class DiameterOfTree {

    public static void main(String[] args) {

        DiameterOfTree d = new DiameterOfTree();

        BTNode node = new BTNode(1);
        node.left = new BTNode(2);
        node.right = new BTNode(3);
        node.right.left = new BTNode(4);
        node.right.right = new BTNode(5);
        node.right.left.left= new BTNode(6);

        d.getDepth(node);

        int val = d.getDiameter(node);
        System.out.println(val);
    }

    private int getDiameter(BTNode root) {
        if(root == null) {
            return 0;
        }

        int lHt = getDepth(root.left);
        int rHt = getDepth(root.right);

        int leftSubTree = getDiameter(root.left);
        int rightSubTree = getDiameter(root.right);

        return Math.max(lHt+rHt+1, Math.max(leftSubTree, rightSubTree));
    }

    public int getDepth(BTNode root) {
        if(root == null) {
            return 0;
        }
        int leftSubtreeDepth = getDepth(root.left);
        int rightSubtreeDepth = getDepth(root.right);
        return Math.max(leftSubtreeDepth, rightSubtreeDepth) + 1;
    }
}
