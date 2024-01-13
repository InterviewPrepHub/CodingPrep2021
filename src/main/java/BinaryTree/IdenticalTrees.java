package BinaryTree;

public class IdenticalTrees {

    public static void main(String[] args) {

        IdenticalTrees d = new IdenticalTrees();

        BTNode node1 = new BTNode(10);
        node1.left = new BTNode(16);
        node1.right = new BTNode(15);
        node1.right.left = new BTNode(18);

        BTNode node2 = new BTNode(10);
        node2.left = new BTNode(16);
        node2.right = new BTNode(15);
        node2.right.left = new BTNode(18);

        boolean flag = d.identicalTree(node1, node2);
        System.out.println(flag);
    }

    private boolean identicalTree(BTNode node1, BTNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return true;
        }

        return node1.data == node2.data && identicalTree(node1.left, node2.left) && identicalTree(node1.right, node2.right);
    }
}
