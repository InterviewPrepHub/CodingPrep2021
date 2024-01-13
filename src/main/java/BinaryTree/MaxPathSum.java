package BinaryTree;

public class MaxPathSum {

    public int maxPathSum(BTNode node) {

        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        // Compute and return result
        findMaxUtil(node, res);
        return res.val;
    }

    int findMaxUtil(BTNode node, Res res) {
        if (node == null)
            return 0;

        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        int max_single = Math.max(Math.max(l, r) + node.data, node.data);

        int max_top = Math.max(max_single, l + r + node.data);

        res.val = Math.max(res.val, max_top);

        return max_single;
    }

    public static void main(String[] args) {

        //[1,2,3]
        //[-10,9,20,null,null,15,7]
        BTNode node = new BTNode(-10);
        node.left = new BTNode(9);
        node.right = new BTNode(20);
        node.right.left = new BTNode(15);
        node.right.right = new BTNode(7);

        MaxPathSum m = new MaxPathSum();
        System.out.println(m.maxPathSum(node));

    }
}

class Res {
    int val;
}