package BinaryTree;

public class InvertBinaryTree {

    public static void main(String[] args) {
        BTNode root = new BTNode(4);
        root.left = new BTNode(2);
        root.left.left = new BTNode(1);
        root.left.right = new BTNode(3);
        root.right = new BTNode(7);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(9);

        InvertBinaryTree b = new InvertBinaryTree();
        b.inorder(root);
        BTNode res = b.invertTree(root);

        System.out.println("After inversion :");
        b.inorder(res);
    }

    private void inorder(BTNode res) {

        if (res == null) {
            return;
        }

        inorder(res.left);
        System.out.println(res.data);
        inorder(res.right);
    }

    private BTNode invertTree(BTNode root) {
        if (root == null) {
            return null;
        }

        //swap the children
        BTNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
