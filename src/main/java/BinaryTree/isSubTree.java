package BinaryTree;

public class isSubTree {

    public static void main(String[] args) {
        BTNode root1 = new BTNode(3);
        root1.left = new BTNode(4);
        root1.left.left = new BTNode(1);
        root1.left.right = new BTNode(2);
        root1.right = new BTNode(5);

        BTNode root2 = new BTNode(4);
        root2.left = new BTNode(1);
        root2.right = new BTNode(2);

        System.out.println(isSubTreeImpl(root1, root2));
    }

    private static boolean isSubTreeImpl(BTNode root, BTNode subRoot) {
        if (root == null) {
            return false;
        }

        if(check(root, subRoot)) {
            return true;
        }

        return isSubTreeImpl(root.left, subRoot) || isSubTreeImpl(root.right, subRoot);
    }

    private static boolean check(BTNode root, BTNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.data != subRoot.data) {
            return false;
        }

        return check(root.left,subRoot.left) && check(root.right, root.right);
    }
}
