package BinaryTree;

public class LowestCommonAncestor {

    static BTNode lca(BTNode curr, BTNode nodeA, BTNode nodeB) {

        if (curr == null) {
            return null;
        }

        if (curr == nodeA || curr == nodeB) {
            return  curr;
        }

        BTNode left = lca(curr.left, nodeA, nodeB);
        BTNode right = lca(curr.right, nodeA, nodeB);

        if (left!=null && right!=null) {
            return curr;
        }
        
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        BTNode node = new BTNode(1);
        node.left = new BTNode(2);
        node.left.left = new BTNode(4);
        node.left.right = new BTNode(5);
        node.left.right.left = new BTNode(7);
        node.left.right.right = new BTNode(8);
        node.right = new BTNode(3);

        BTNode res = lca(node, node.left.left, node.left.right.right);
        System.out.println(res.data);

    }
}
