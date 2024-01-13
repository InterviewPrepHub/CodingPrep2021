package BinaryTree;

public class MergeTwoBT {

    public static void main(String[] args) {
        BTNode root1 = new BTNode(1);
        root1.left = new BTNode(3);
        root1.right = new BTNode(2);
        root1.left.left = new BTNode(5);

        BTNode root2 = new BTNode(2);
        root2.left = new BTNode(1);
        root2.right = new BTNode(3);
        root2.left.right = new BTNode(4);
        root2.right.right = new BTNode(7);

        MergeTwoBT m = new MergeTwoBT();
        BTNode root3 = m.merge(root1, root2);
        m.inorder(root3);

    }

    private void inorder(BTNode res) {
        if (res == null) {
            return;
        }

        inorder(res.left);
        System.out.println(res.data);
        inorder(res.right);
    }

    private BTNode merge(BTNode root1, BTNode root2) {

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.data += root2.data;

        root1.left = merge(root1.left, root2.left);
        root1.right = merge(root1.right, root2.right);

        return root1;
    }
}
