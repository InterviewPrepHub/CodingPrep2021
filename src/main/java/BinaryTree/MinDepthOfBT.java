package BinaryTree;

public class MinDepthOfBT {

    static int getMinDepth(BTNode node) {
        if (node == null) return 0;

        if (node.left == null || node.right == null) return 1;

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (node.left != null) {
            left = getMinDepth(node.left);
        }
        if (node.right != null) {
            right = getMinDepth(node.right);
        }

        return 1+ Math.min(left, right);
    }

    public static void main(String[] args) {
        BTNode node = new BTNode(1);
        node.left = new BTNode(2);
        node.right = new BTNode(3);
        node.right.left = new BTNode(4);
        node.right.right = new BTNode(5);
        node.right.left.left= new BTNode(6);
        System.out.println(getMinDepth(node));
    }
}
