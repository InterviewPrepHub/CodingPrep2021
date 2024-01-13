package BinaryTree;

public class RecoverBinaryTree {

    static BTNode firstStartPoint, lastStartPoint, prevNode;

    static void findSegment(BTNode node) {
        if (node == null) {
            return;
        }
        findSegment(node.left);
        if (prevNode != null) {
            if (prevNode.data > node.data) {
                if (firstStartPoint == null) {
                    firstStartPoint = prevNode;
                }
                lastStartPoint = node;
            }
        }
        prevNode = node;
        findSegment(node.right);
    }

    static void recoverBT(BTNode node) {
        findSegment(node);
        int x = firstStartPoint.data;
        firstStartPoint.data = lastStartPoint.data;
        lastStartPoint.data = x;
    }

    public static void main(String[] args) {
        /*BTNode node = new BTNode(10);
        node.left = new BTNode(15);
        node.right = new BTNode(5);
        node.left.left = new BTNode(4);
        node.left.right = new BTNode(7);
        node.right.left = new BTNode(14);
        node.right.right = new BTNode(17);*/

        BTNode node = new BTNode(10);
        node.left = new BTNode(5);
        node.right = new BTNode(14);
        node.left.left = new BTNode(4);
        node.left.right = new BTNode(7);
        node.right.left = new BTNode(15);
        node.right.right = new BTNode(17);

        System.out.println("Before");
        inorderTraversal(node);

        recoverBT(node);

        System.out.println();
        System.out.println("After");
        inorderTraversal(node);
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
